package com.example.pocketHero.domains.creation;

public enum HitDie {
    D4(4), D6(6), D8(8), D10(10), D12(12);

    private final int value;

    

    HitDie(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static HitDie fromValue(String hitDie2) {
        for (HitDie hitDie : values()) {
            if (hitDie.name().equalsIgnoreCase(hitDie2)) {
                return hitDie;
            }
        }
        throw new IllegalArgumentException("Valor desconocido: " + hitDie2);
    }


    HitDie getHitDie(HitDie hitDie) {
        return hitDie;}
}