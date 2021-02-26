import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Directory {

    private List<File> files;
    private String path;

    public Directory() {
    }

    public Directory(String path) {
        this.path = path;
        initialize();
    }

    private static final Comparator<File> sortFileByName() {
        Comparator comp = new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return file1.getName().compareTo(file2.getName());
            }
        };
        return comp;
    }

    private void initialize() {
        this.files = new ArrayList<>();
        File[] files = new File(this.path).listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.
        for (File file : files) {
            this.files.add(file);
        }

    }

    public List<File> getFiles() {
        return files;
    }

    public Directory setFiles(List<File> files) {
        this.files = files;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Directory setPath(String path) {
        this.path = path;
        return this;
    }

    public void listFilesInSortedOrder() {
        System.out.println();
        Collections.sort(this.files, Directory.sortFileByName());
        for (File file : this.files) {
            System.out.println(file.getName() + "\t");
        }
        System.out.println();
        //        return List.of(this.path);
    }

    public String addFile(String fileName) throws IOException {
        Files.createFile(Path.of(this.path + "/" + fileName));
        initialize();
        return "success";
    }

    public String deleteFile(String fileName) throws IOException {
        Files.deleteIfExists(Path.of(this.path + "/" + fileName));
        initialize();
        return "success";

    }

    public String searchFile(String fileName) {
        Paths.get(this.path + "/" + fileName);
        return "success";

    }

    public String executeOperation(Integer operation, String fileName) throws IOException {
        String operationResponse = "";
        switch (operation) {
            case 1:
                operationResponse = this.addFile(fileName);
                break;
            case 2:
                operationResponse = this.deleteFile(fileName);
                break;
            case 3:
                operationResponse = this.searchFile(fileName);
                break;
        }
        return operationResponse;
    }

}
