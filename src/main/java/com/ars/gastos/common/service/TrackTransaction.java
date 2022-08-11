package com.ars.gastos.common.service;

public class TrackTransaction {
    private String name;
    private long startTime;
    private long EndTime;
    private long elapsedTime;

    public TrackTransaction(String name) {
        this.name = name;
    }

    public void beginTransaction() {
        startTime = System.nanoTime();
    }

    public void finishTransaction() {
        EndTime = System.nanoTime();
        elapsedTime = EndTime - startTime;
    }

    public long getElepsedTimeMilis() {
        return this.elapsedTime / 1000000;
    }

    public long getElepsedTimeNanos() {
        return this.elapsedTime;
    }

    public String printInfoTransactionMilis() {
        return String.format("The transaction %s took %d miliseconds", this.name, this.getElepsedTimeMilis());
    }

    public String printInfoTransactionNanos() {
        return String.format("The transaction %s took %d nanoseconds", this.name, this.getElepsedTimeNanos());
    }

}
