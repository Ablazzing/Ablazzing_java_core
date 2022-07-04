package homework2.lesson3advanced;

public class Workers {

    private String workerName;
    private int workerId;

    private static int annihilatedVodka = 0;

    public Workers(String workerName, int workerId) {
        this.workerName = workerName;
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public static int getAnnihilatedVodka() {
        return annihilatedVodka;
    }

    public void annihilatingVodka(Integer vodkaTaken) {
        Storage.setVodka(Storage.getVodka() - vodkaTaken);
        System.out.println("Ура я испортил водку!");
        Workers.annihilatedVodka += vodkaTaken;
    }
}
