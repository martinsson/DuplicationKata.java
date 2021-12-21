package org.learnwithllew.duplicationkata;

import java.util.HashMap;
import java.util.Map;

public class Lesson31 extends Song {
    public void singSong(int style, String... names) {
        Map<Integer, Singer> singerTypes = new HashMap<>() {{
            put(1, new BirthDaySinger());
            put(2, new YaySinger());
            put(3, new BaseSinger());
        }};
        NoSinger defaultValue = new NoSinger();

        Singer singer = singerTypes.getOrDefault(style, defaultValue);
        singer.doSing(names);
    }

    interface Singer {
        void doSing(String[] names);
    }

    private class BaseSinger implements Singer {

        public void doSing(String[] names) {
            for (String name : names) {
                sing(getLineToSing(name));
            }
        }

        private String getLineToSing(String name) {
            return this.isSpecialPerson(name) ? this.singSpecial(name) : "Hello " + name + ", it's nice to meet you.";
        }

        public boolean isSpecialPerson(String name) {
            return false;
        }

        public String singSpecial(String name) {
            return null;
        }

    }

    private class BirthDaySinger extends BaseSinger {
        public boolean isSpecialPerson(String name) {
            return name.startsWith("L");
        }

        public String singSpecial(String name) {
            return "Hip Hip Horray! For " + name;
        }

    }

    private class YaySinger extends BaseSinger {

        public boolean isSpecialPerson(String name) {
            return name.contains("a");
        }

        @Override
        public String singSpecial(String name) {
            return name.toUpperCase() + "! Yay " + name + "!";
        }

    }

    private class NoSinger implements Singer {
        @Override
        public void doSing(String[] names) {

        }
    }
}
