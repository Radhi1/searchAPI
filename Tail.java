package com.radhika.naik.java.tail.program.main;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Tail {

	public long filePosition = 0;

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Usage: rTail <filename>");
			return;
		}

		Tail tailFile = new Tail();
		WatchService watcher = FileSystems.getDefault().newWatchService();
		Path filePath = FileSystems.getDefault().getPath(args[0]);
		Path parentDirPath = filePath.getParent();
		parentDirPath.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
		
		tailFile.tailTheFile(filePath);

		while (true) {
			WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException ex) {
                return;
            }
             
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                 
                @SuppressWarnings("unchecked")
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path fileName = ev.context();
                 
                //System.out.println(kind.name() + ": " + fileName);
                 
                if (kind == StandardWatchEventKinds.ENTRY_MODIFY && filePath.getFileName().toString().compareToIgnoreCase(fileName.toString()) == 0) {
                	tailFile.tailTheFile(filePath);
                	//System.out.println("file updated..." + fileName.getFileName());
                }
            }
             
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }

	}

	public void tailTheFile(Path filePath) {

		try {
			SeekableByteChannel sbc = Files.newByteChannel(filePath);
			ByteBuffer buffer = ByteBuffer.allocate(2);

			sbc.position(filePosition);
			while (sbc.read(buffer) > 0) {
				buffer.flip();
				filePosition = sbc.position();
				System.out.print(Charset.defaultCharset().decode(buffer));
				buffer.rewind();
			}
			sbc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
