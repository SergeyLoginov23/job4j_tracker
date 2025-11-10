package ru.job4j.hashmap;

import java.util.HashMap;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        List<Label> result = averageScoreByPupil(pupils);
        double totalSum = 0;
        int pupilNumber = result.size();
        for (Label label: result) {
            totalSum = totalSum + label.score();
        }
        return totalSum / pupilNumber;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> listSubj = pupil.subjects();            
            double totalSum = 0;
            int subjNumber = listSubj.size();
            for (Subject subject : listSubj) {
                totalSum = totalSum + subject.score();                
            }
            result.add(new Label(pupil.name(), totalSum / subjNumber));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        HashMap<String, Double> map = new HashMap<>();
        BiFunction<Double, Double, Double> function = (oldValue, newValue) -> oldValue + newValue;
        int subjNumber = pupils.size();
        for (Pupil pupil : pupils) {
            List<Subject> listSubj = pupil.subjects();
            for (Subject subject : listSubj) {
                map.merge(subject.name(), Double.valueOf(subject.score()), function);
            }
        }
        for (String key : map.keySet()) {
            result.add(new Label(key, map.get(key) / subjNumber));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> scoreList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> listSubj = pupil.subjects();
            double totalSum = 0;
            for (Subject subject : listSubj) {
                totalSum = totalSum + subject.score();
            }
            scoreList.add(new Label(pupil.name(), totalSum));
        }
        System.out.println(scoreList);
        scoreList.sort(Comparator.naturalOrder());
        return scoreList.get(scoreList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> scoreList = new ArrayList<>();
        HashMap<String, Double> map = new HashMap<>();
        BiFunction<Double, Double, Double> function = (oldValue, newValue) -> oldValue + newValue;
        for (Pupil pupil : pupils) {
            List<Subject> listSubj = pupil.subjects();
            for (Subject subject : listSubj) {
                map.merge(subject.name(), Double.valueOf(subject.score()), function);
            }
        }
        for (String key : map.keySet()) {
            scoreList.add(new Label(key, map.get(key)));
        }
        scoreList.sort(Comparator.naturalOrder());
        return scoreList.get(scoreList.size() - 1);
    }
}