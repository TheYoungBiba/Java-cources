package edu.hw10.task1.objects;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;

public record MyHumanRecordWithAnnotations(@NotNull String name, @Min(0) @Max(100) int age) {}
