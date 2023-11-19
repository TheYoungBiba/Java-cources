package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw6.task3.AttributeFilter.readableFile;
import static edu.hw6.task3.AttributeFilter.writableFile;
import static edu.hw6.task3.ExtensionFilter.globMatches;
import static edu.hw6.task3.MagicNumberFilter.magicNumber;
import static edu.hw6.task3.NameFilter.regexContains;
import static edu.hw6.task3.SizeFilter.largerThan;
import static edu.hw6.task3.SizeFilter.smallerThan;
import static edu.hw6.task3.AttributeFilter.regularFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task3Test {

    private static Stream<Arguments>  provideTestCasesForSizeFilterTest() throws IOException {
        Path testCase = Path.of("src","main","resources","test1.txt");
        Files.createFile(testCase);
        String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat";
        Files.writeString(testCase, text1);

        Path testCase2 = Path.of("src","main","resources","test2.txt");
        Files.createFile(testCase2);
        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        Files.writeString(testCase2, text2);

        Path testCase3 = Path.of("src","main","resources","test3.txt");
        Files.createFile(testCase3);
        String text3 = "Lorem ipsum";
        Files.writeString(testCase3, text3);
        return Stream.of(
            Arguments.of(regularFile().and(smallerThan(100_000)), List.of(
                Path.of("src","main","resources","image.png"), testCase, testCase2, testCase3)
            ),
            Arguments.of(largerThan(100_000), List.of()
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForSizeFilterTest")
    void sizeFilterTest(DirectoryStream.Filter filter, List<Path> referent) throws IOException {
        DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("src", "main", "resources"), filter);
        boolean flag = true;
        int cursor = 0;
        for(Path file : ds){
            if(!file.equals(referent.get(cursor))){
                flag = false;
                break;
            }
            cursor++;
        }
        for(Path path : referent){
            if(!path.getFileName().toString().endsWith("image.png")){
                Files.delete(path);
            }
        }
        assertTrue(flag);
    }


    @Test
    void magicNumberTest() throws IOException {
        Path testCase2 = Path.of("src","main","resources","test2.txt");
        Files.createFile(testCase2);
        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        Files.writeString(testCase2, text2);

        Path testCase3 = Path.of("src","main","resources","test3.txt");
        Files.createFile(testCase3);
        String text3 = "Lorem ipsum";
        Files.writeString(testCase3, text3);

        DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("src", "main", "resources"), magicNumber(0x89, 'P','N','G'));
        boolean flag = true;
        int cursor = 0;
        List<Path> referent = List.of(Path.of("src","main","resources","image.png"), testCase2, testCase3);
        for(Path file : ds){
            if(!file.equals(referent.get(cursor))){
                flag = false;
                break;
            }
            cursor++;
        }
        for(Path path : referent){
            if(!path.getFileName().toString().endsWith("image.png")){
                Files.delete(path);
            }
        }
        assertTrue(flag && cursor > 0);
    }

    private static List<Path> getListOfPaths() throws IOException {
        Path testCase = Path.of("src","main","resources","test1.txt");
        Files.createFile(testCase);
        String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat";
        Files.writeString(testCase, text1);

        Path testCase2 = Path.of("src","main","resources","test2.txt");
        Files.createFile(testCase2);
        String text2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        Files.writeString(testCase2, text2);

        Path testCase3 = Path.of("src","main","resources","test3.txt");
        Files.createFile(testCase3);
        String text3 = "Lorem ipsum";
        Files.writeString(testCase3, text3);
        return List.of(
            Path.of("src","main","resources","image.png"),
            testCase,
            testCase2,
            testCase3
        );
    }

    @Test
    void readableFileTest() throws IOException {
        List<Path> referent = getListOfPaths();
        DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("src", "main","resources"),readableFile());
        boolean flag = true;
        int cursor = 0;
        for(Path file : ds){
            if(!file.equals(referent.get(cursor))){
                flag = false;
                break;
            }
            cursor++;
        }
        for(Path path : referent){
            if(!path.getFileName().toString().endsWith("image.png")){
                Files.delete(path);
            }
        }
        assertTrue(flag && cursor>0);
    }

    @Test
    void writeableFileTest() throws IOException {
        List<Path> referent = getListOfPaths();
        DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("src", "main","resources"), writableFile());
        boolean flag = true;
        int cursor = 0;
        for(Path file : ds){
            if(!file.equals(referent.get(cursor))){
                flag = false;
                break;
            }
            cursor++;
        }
        for(Path path : referent){
            if(!path.getFileName().toString().endsWith("image.png")){
                Files.delete(path);
            }
        }
        assertTrue(flag && cursor>0);
    }

    @Test
    void regularFileTest() throws IOException {
        List<Path> referent = getListOfPaths();
        DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("src", "main","resources"), regularFile());
        boolean flag = true;
        int cursor = 0;
        for(Path file : ds){
            if(!file.equals(referent.get(cursor))){
                flag = false;
                break;
            }
            cursor++;
        }
        for(Path path : referent){
            if(!path.getFileName().toString().endsWith("image.png")){
                Files.delete(path);
            }
        }
        assertTrue(flag && cursor>0);
    }

    @Test
    void nameFilterTest() throws IOException {
        List<Path> list = new ArrayList<>();

        Path testCase2 = Path.of("src","main","resources","test-2.txt");
        Files.createFile(testCase2);
        list.add(testCase2);

        Path testCase3 = Path.of("src","main","resources","test3.txt");
        Files.createFile(testCase3);
        list.add(testCase3);

        Path testCase = Path.of("src","main","resources","test.png");
        Files.createFile(testCase);
        list.add(testCase);

        DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("src", "main","resources"), regexContains("[2]"));
        List<Path> referent = List.of(testCase2);
        boolean flag = true;
        int cursor = 0;
        for(Path file : ds){
            if(!file.equals(referent.get(cursor))){
                flag = false;
                break;
            }
            cursor++;
        }
        for(Path path : list){
            Files.delete(path);
        }
        assertTrue(flag && cursor>0);
    }


    @Test
    void extensionFilterTest() throws IOException {
        List<Path> list = new ArrayList<>();

        Path testCase2 = Path.of("src","main","resources","test2.txt");
        Files.createFile(testCase2);
        list.add(testCase2);

        Path testCase3 = Path.of("src","main","resources","test3.txt");
        Files.createFile(testCase3);
        list.add(testCase3);

        Path testCase = Path.of("src","main","resources","test.png");
        Files.createFile(testCase);
        list.add(testCase);

        DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of("src", "main","resources"), globMatches("*.png"));
        List<Path> referent = List.of(Path.of("src","main","resources", "image.png"), testCase);
        boolean flag = true;
        int cursor = 0;
        for(Path file : ds){
            if(!file.equals(referent.get(cursor))){
                flag = false;
                break;
            }
            cursor++;
        }

        for(Path path : list){
            if(!path.getFileName().toString().endsWith("image.png")){
                Files.delete(path);
            }
        }
        assertTrue(flag);
    }

}
