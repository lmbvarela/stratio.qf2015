/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lvarela.stratic.algoritmo.queima;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Luis Varela
 */
public class Algorithm {

    private final PriorityQueue<Branch> queue = new PriorityQueue<>();
    private final Table<String, String, Float> distances = HashBasedTable.create();
    private Set<String> cities;

    private String start;
    private String end;

    public Algorithm(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public void load() {
        this.cities = this.distances.columnKeySet();
    }

    public void put(String a, String b, Float c) {
        this.distances.put(a, b, c);
        this.distances.put(b, a, c);
    }

    public Branch run() {
        Branch best;

        this.queue.add(new Branch(this.start));

        do {
            best = this.queue.poll();
            for (String city : this.cities) {
                if (!best.contains(city)) {
                    Stack<String> leafs = (Stack) best.getLeafs().clone();
                    Float lenght = best.getLenght() + this.distances.get(leafs.lastElement(), city);
                    leafs.add(city);
                    this.queue.add(new Branch(leafs, lenght));
                }
            }
        } while (!queue.peek().contains(start, end));

        return queue.peek();
    }

    public void print() {
        while (this.queue.size() > 0) {
            this.queue.poll().print();
        }
    }

}
