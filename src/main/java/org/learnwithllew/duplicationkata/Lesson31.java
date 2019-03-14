package org.learnwithllew.duplicationkata;

import java.util.HashMap;
import java.util.Map;

public class Lesson31 extends Song {
    public void singSong(int style, String... names) {
        Map<Integer, Singer> singerTypes = new HashMap<>() {{
            put(1, new BirthDaySinger());
            put(2, new YaySinger());
            put(3, new BoringSinger());
        }};
        NoSinger defaultValue = new NoSinger();
        Singer singer = singerTypes.getOrDefault(style, defaultValue);
        singer.doSing(names);
    }


    private boolean isRightPerson(String name) {
        return name.contains("a");
    }

    interface Singer {


        void doSing(String[] names);
    }

    private class BirthDaySinger extends BoringSinger {
        public boolean isRightPerson(String name) {
            return name.startsWith("L");
        }

        public String singSpecial(String name) {
            return "Hip Hip Horray! For " + name;
        }

    }

    private class YaySinger extends BoringSinger {

        public boolean isRightPerson(String name) {
            return name.contains("a");
        }

        @Override
        public String singSpecial(String name) {
            return name.toUpperCase() + "! Yay " + name + "!";
        }

    }

    private class BoringSinger implements Singer {

        public void doSing(String[] names) {
            for (String name : names) {
                if (this.isRightPerson(name)) {
                    sing(this.singSpecial(name));

                } else {
                    sing(this.singBoring(name));
                }
            }
        }

        public boolean isRightPerson(String name) {
            return false;
        }

        public String singSpecial(String name) {
            return null;
        }

        public String singBoring(String name) {
            return "Hello " + name + ", it's nice to meet you.";
        }
    }

    private class NoSinger implements Singer {
        @Override
        public void doSing(String[] names) {

        }
    }
}
