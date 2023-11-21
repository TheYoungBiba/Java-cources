package edu.project3;

import edu.project3.LogAnalyzer.MostRequestedResource;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

public class Renderer {
    private Renderer() {}

    @SuppressWarnings("magicnumber")
    public static String mainInformationRender(List<Path> listOfPath, ZonedDateTime from, ZonedDateTime to,
        long countOfRequests, long mediumSizeOfServerAns) {
        final int lengthOfValueName = 8;
        StringBuilder render = new StringBuilder("#### Общая информация\n\n");
        StringBuilder fileNames = new StringBuilder("|Файл(-ы)              |");
        Path[] arrayOfPath = listOfPath.toArray(new Path[0]);
        for (Path value : arrayOfPath) {
            fileNames.append(value.getFileName());
            fileNames.append(", ");
        }
        fileNames.delete(fileNames.length() - 2, fileNames.length() - 1);
        fileNames.append("|\n");
        List<Integer> listOfMaxLengths = List.of(
            fileNames.length() - 2,
            from != null ? from.toString().length() : 0,
            to != null ? to.toString().length() : 0,
            String.valueOf(countOfRequests).length(),
            String.valueOf(mediumSizeOfServerAns).length() + 1,
            lengthOfValueName);
        int maxLength = listOfMaxLengths.stream()
                .filter(Objects::nonNull)
                .max(Integer::compareTo)
                .get();
        render.append(stringLengthLeveler("|Метрика               |Значение", maxLength));
        render.append("\n");
        render.append(getLine("|----------------------|", maxLength));
        render.append("\n");
        render.append(fileNames);
        if (from != null) {
            render.append(stringLengthLeveler("|Начальная дата        |" + from, maxLength));
            render.append("\n");
        } else {
            render.append(stringLengthLeveler("|Начальная дата        | - ", maxLength));
            render.append("\n");
        }
        if (to != null) {
            render.append(stringLengthLeveler("|Конечная дата         |" + to, maxLength));
            render.append("\n");
        } else {
            render.append(stringLengthLeveler("|Конечная дата         | - ", maxLength));
            render.append("\n");
        }
        render.append(stringLengthLeveler("|Количество запросов   |" + countOfRequests, maxLength));
        render.append("\n");
        render.append(stringLengthLeveler("|Средний размер ответа |" + mediumSizeOfServerAns + "b",
            maxLength));
        render.append("\n");
        return render.toString();
    }

    @SuppressWarnings("magicnumber")
    public static String resourcesRender(List<MostRequestedResource> listOfResources) {
        StringBuilder render = new StringBuilder("#### Запрашиваемые ресурсы\n\n");
        final int lengthOfResourceName = 6;
        final int lengthOfCountName = 10;
        int maxLengthOfResource = listOfResources.stream()
            .map(mostRequestedResource -> mostRequestedResource.name().length())
            .max(Integer::compareTo)
            .get();
        maxLengthOfResource = Math.max(maxLengthOfResource, lengthOfResourceName);
        long maxCounter = listOfResources.stream()
            .map(MostRequestedResource::count)
            .max(Long::compareTo)
            .get();
        int maxLengthOfCounter = Math.max(String.valueOf(maxCounter).length() + 1, lengthOfCountName);
        int fullLength = maxLengthOfResource + maxLengthOfCounter + 4;
        render.append(stringLengthLeveler(stringLengthLeveler(
            "|Ресурс", maxLengthOfResource + 2) + "Количество",
            fullLength));
        render.append("\n");
        render.append(getLine(getLine("|", maxLengthOfResource + 2), fullLength));
        render.append("\n");
        for (MostRequestedResource resource: listOfResources.toArray(new MostRequestedResource[0])) {
            render.append(stringLengthLeveler(
                stringLengthLeveler("|" + resource.name(), maxLengthOfResource + 2)
                    + resource.count(), fullLength));
            render.append("\n");
        }
        return render.toString();
    }

    @SuppressWarnings("magicnumber")
    public static String codeRenderer(List<LogAnalyzer.MostFrequentCode> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#### Коды ответа\n\n");
        stringBuilder.append("|Код |Имя                           |Количество |\n");
        stringBuilder.append("|----|------------------------------|-----------|\n");
        LogAnalyzer.MostFrequentCode[] array = new LogAnalyzer.MostFrequentCode[list.size()];
        list.toArray(array);
        for (LogAnalyzer.MostFrequentCode code: array) {
            stringBuilder.append("|" + code.statusCode().getCode() + " |" + code.statusCode());
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

    private static String stringLengthLeveler(String value, int valuableLength) {
        return value + " ".repeat(Math.max(1, valuableLength - value.length())) + "|";
    }

    private static String getLine(String baseLine, int valuableLength) {
        return baseLine + "-".repeat(valuableLength - baseLine.length()) + "|";
    }
}
