package lesson3;

public class Cat {
    private String voice = "meow";
    private int paws = 4;

    public Cat(String voice, int paws) {
        this.voice = voice;
        this.paws = paws;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public int getPaws() {
        return paws;
    }

    public void setPaws(int paws) {
        this.paws = paws;
    }
}
