package com.sia.java.homework.java_2019_04_11_tank_oop.util;

public class Map {
    private Object[] obj = new Object[2];
    private boolean enemyBossIsAlive = true;
    private boolean myBossIsAlive = true;
    {
        int[][] map1 = new int[][]{
                {1,2,1,2,1,2,0,2,6,2,0,2,1,2,1,2,1},
                {1,2,1,2,1,2,1,2,2,2,1,2,1,2,1,2,1},
                {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
                {2,1,2,1,3,3,3,3,2,3,3,3,3,1,2,1,2},
                {1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,2,1},
                {2,1,2,1,3,3,3,3,2,3,3,3,3,1,2,1,2},
                {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1},
                {1,2,1,2,1,2,1,2,2,2,1,2,1,2,1,2,1},
                {1,2,1,2,1,2,0,2,5,2,0,2,1,2,1,2,1}};
        int[][] map2 = new int[][]{
                {0,0,0,0,0,0,0,2,6,2,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,2,5,2,0,0,0,0,0,0,0},};
        obj[0] = map1;
        obj[1] = map2;
    }

    public Object[] getObj() {
        return obj;
    }

    public void setObj(Object[] obj) {
        this.obj = obj;
    }

    public boolean isEnemyBossIsAlive() {
        return enemyBossIsAlive;
    }

    public void setEnemyBossIsAlive(boolean enemyBossIsAlive) {
        this.enemyBossIsAlive = enemyBossIsAlive;
    }

    public boolean isMyBossIsAlive() {
        return myBossIsAlive;
    }

    public void setMyBossIsAlive(boolean myBossIsAlive) {
        this.myBossIsAlive = myBossIsAlive;
    }
}
