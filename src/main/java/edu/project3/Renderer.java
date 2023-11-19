package edu.project3;

import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.List;

public class Renderer {
    private Renderer() {}

    public static String mainInformationRender(List<Path> listOfPath, ZonedDateTime from, ZonedDateTime to,
        long countOfRequests, long mediumSizeOfServerAns) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#### Общая информация\n\n");
        int lengthOfFiles = listOfPath.stream()
            .reduce(0, (integer, path) -> integer + path.getFileName().toString().length() + 3, Integer::sum);
        String tempLine = "|-----------------------|";
        for (int i = 0; i < lengthOfFiles; i++) {
            tempLine = tempLine + "-";
        }
        String temp = "|Метрика                |Значение";
        for (int i = 8; i < lengthOfFiles; i++) {
            temp = temp + " ";
        }
        stringBuilder.append(temp + "|\n");

        stringBuilder.append(tempLine + "|");
        stringBuilder.append("\n");
        String tempFiles = "|Файл(-ы)               |";
        for (Object o: listOfPath.stream().map(path -> path.getFileName()).toArray()) {
            tempFiles = tempFiles + o.toString() + ", ";
        }
        stringBuilder.append(tempFiles + " |");
        stringBuilder.append("\n");
        if (from != null) {
            stringBuilder.append("|Начальная дата         |" + from);
            for (int i = from.toString().length(); i < lengthOfFiles; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("|\n");
        } else {
            stringBuilder.append("|Начальная дата         | -");
            for (int i = 0; i < lengthOfFiles - 2; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("|\n");
        }
        if (from != null) {
            stringBuilder.append("|Конечная дата          |" + to);
            for (int i = to.toString().length(); i < lengthOfFiles; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("|\n");
        } else {
            stringBuilder.append("|Конечная дата          | -");
            for (int i = 0; i < lengthOfFiles - 2; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("|\n");
        }
        stringBuilder.append("|Количество запросов    |" + countOfRequests);
        for (int i = String.valueOf(countOfRequests).length(); i < lengthOfFiles; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("|\n");
        stringBuilder.append("|Средний размер ответа  |" + mediumSizeOfServerAns + "b");
        for (int i = String.valueOf(mediumSizeOfServerAns).length() + 1; i < lengthOfFiles; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("|\n");
        return stringBuilder.toString();
    }

    public static String resourcesRender(List<LogAnalyzer.MostRequestedResource> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#### Запрашиваемые ресурсы\n\n");
        int length = list.stream().map(mostRequestedResource
            -> mostRequestedResource.name().length()).max(Integer::compareTo).get();
        String resource = "|Ресурс";
        for (int i = 5; i < length; i++) {
            resource = resource + " ";
        }
        resource += "|Количество |\n";
        stringBuilder.append(resource);
        String tempLine = "|";
        for (int i = 0; i < length + 1; i++) {
            tempLine = tempLine + "-";
        }
        tempLine += "|-----------|\n";
        stringBuilder.append(tempLine);
        StringBuilder tempRsource = new StringBuilder();
        LogAnalyzer.MostRequestedResource[] array = new LogAnalyzer.MostRequestedResource[list.size()];
        list.toArray(array);
        for (int i = 0; i < array.length; i++) {
            tempRsource.append("|" + array[i].name());
            for (int j = array[i].name().length(); j < length; j++) {
                tempRsource.append(" ");
            }
            tempRsource.append(" |" + array[i].count());
            for (int j = String.valueOf(array[i].count()).length(); j < 11; j++) {
                tempRsource.append(" ");
            }
            tempRsource.append("|\n");
        }
        stringBuilder.append(tempRsource.toString());
        return stringBuilder.toString();
    }

    @SuppressWarnings("magicnumber")
    public static String codeRenderer(List<LogAnalyzer.MostFrequentCode> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#### Коды ответа\n\n");
        stringBuilder.append("|Код |Имя                           |Количество |\n");
        stringBuilder.append("|----|------------------------------|-----------|\n");
        LogAnalyzer.MostFrequentCode[] array = new LogAnalyzer.MostFrequentCode[list.size()];
        list.toArray(array);
        for (LogAnalyzer.MostFrequentCode code:
             array) {
            stringBuilder.append("|" + code.statusCode().getCode() + " |" +code.statusCode());
            for (int i = code.statusCode().toString().length(); i < 30; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("|" + code.count());
            for (int i = String.valueOf(code.count()).length(); i < 11; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("|\n");
        }
        return stringBuilder.toString();
    }
}
