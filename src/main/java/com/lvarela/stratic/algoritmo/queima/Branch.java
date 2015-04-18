/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lvarela.stratic.algoritmo.queima;

import java.util.Stack;

/**
 *
 * @author Luis Varela
 */
public class Branch implements Comparable {

    private Stack<String> leafs = new Stack<String>();
    private Float lenght = 0.0f;

    public Branch(String leaf) {
        this.leafs.add(leaf);
        this.lenght = 0.0f;
    }

    public Branch(Stack<String> leafs, Float lenght) {
        this.leafs = leafs;
        this.lenght = lenght;

    }

    public Stack<String> getLeafs() {
        return leafs;
    }

    public void setLeafs(Stack<String> leafs) {
        this.leafs = leafs;
    }

    public float getLenght() {
        return lenght;
    }

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public boolean contains(String leaf) {
        return this.leafs.contains(leaf);
    }

    public boolean contains(String leafA, String leafB) {
        return this.contains(leafA) && this.contains(leafB);
    }

    @Override
    public int compareTo(Object t) {
        return this.lenght.compareTo(((Branch) t).lenght);
    }

    public void print() {
        for (String s : this.leafs) {
            System.out.print(s);
            System.out.print("/");
        }
        System.out.println("-"+this.lenght);
    }
}
