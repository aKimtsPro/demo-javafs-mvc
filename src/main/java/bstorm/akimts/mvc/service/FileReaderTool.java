package bstorm.akimts.mvc.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FileReaderTool {

    private final Scanner scanner;

    public FileReaderTool(Scanner scanner) {
        this.scanner = scanner;
    }
}
