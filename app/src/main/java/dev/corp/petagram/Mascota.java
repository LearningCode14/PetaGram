package dev.corp.petagram;

public class Mascota {
    private int foto;
    private String petName;
    private int score;

    public Mascota(int foto, String petName, int score)
    {
        this.foto = foto;
        this.petName = petName;
        this.score = score;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getScore() {
        String scor = String.valueOf(score);
        return scor;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
