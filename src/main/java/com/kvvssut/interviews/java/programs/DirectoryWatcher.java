package com.kvvssut.interviews.java.programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class DirectoryWatcher {

	public static void main(String[] args) {
		String stroageLocation = "/home/srimantas/Desktop/secured-storage";
		Path path = Paths.get(stroageLocation);
		listFilesForFolder(path);
		registerDirectory(path);
		
	}
	
	public static void registerDirectory(final Path path) {
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WatchKey watchKey = null;
		while (true) {
		    try {
				watchKey = watchService.poll(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    if(watchKey != null) {
		        watchKey.pollEvents().stream().forEach(event -> System.out.println(event.context()));
			    watchKey.reset();
		    }
		}
		
	}
	
	public static void listFilesForFolder(final Path path) {
		try(Stream<Path> paths = Files.walk(path)) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		            System.out.println(filePath);
		        }
		    });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
}
