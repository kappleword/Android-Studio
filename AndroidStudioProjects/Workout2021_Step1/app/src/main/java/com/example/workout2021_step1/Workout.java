package com.example.workout2021_step1;

public class Workout {
    private String name = null;
    private String description = null;
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Workout(String name, String description){
        this.name = name;
        this.description = description;
    }
    public static Workout[] workouts = {
            new Workout("등운동","3 벤트오버 바벨로우\n3 렛폴다운\n3 덤벨로우 ")
            ,new Workout("가슴운동","3 푸시업\n3 덤벨프레스\n3 케이블크로스오버 ")
            ,new Workout("하체운동","3 스쿼트\n3 레그프레스\n3 투명의자 ")
    };
}
