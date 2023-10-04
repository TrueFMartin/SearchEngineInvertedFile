package com.truefmartin;

/**
 * Filename: HashTabe.java
 * Author: Susan Gauch, converted to java by Matt Miller, debugged by Patrick Anderson.
 *
 * Modified by: Franklin True Martin for use in inversion algorithm.
 */

import java.io.IOException;

public class HashTable
{
    private int size;
    private long used;
    private long collision;
    private long lookups;
    private Node[] hashtable;

    private final static int TERM_SIZE = HTMLParser.TERM_SIZE;
    private final static int FREQ_SIZE = HTMLParser.FREQ_SIZE;

    /**
     * Initializes a hashtable with size 3 times the size given.
     * @param size One third of the hashtable size;
     */
    public HashTable(int size)
    {
        this.size=size*3;
        init();
    }

    /**
     * Copies a hashtable
     * @param ht
     */
    public HashTable(HashTable ht)
    {
        this.size=ht.getSize();
        used=ht.getUsed();
        collision=ht.getCollisions();
        lookups=ht.getLookups();
        hashtable=new Node[this.size];

        for(int i=0;i<this.size;i++)
            hashtable[i]=new Node(ht.getNode(i).getTerm(),ht.getNode(i).getFreq());
    }

    /**
     * Method to be called by constructors.
     * Also an easy way to reset a already made hashtable.
     * Requires that size already be set.
     */
    public void init()
    {
        used=0;
        collision=0;
        lookups=0;
        hashtable=new Node[this.size];

        //initialize the hashtable
        for(int i=0;i<this.size;i++)
            hashtable[i]=new Node("empty",-1);
    }

    public int getNumUniqueTerms() {
        int numUnique = 0;
        for (Node node: hashtable) {
            if (node.freq != -1) {
                numUnique++;
            }
        }
        return numUnique;
    }

    /**
     * Prints the contents of the hashtable to the file given.
     *
     * @param filename String
     * @return
     */
    public StringBuilder print()
    {

        StringBuilder out = new StringBuilder(size*20);

        for(int i=0;i<size;i++)
        {

            String termStr = hashtable[i].getTerm();
            int termSpaceSize = 1;
            if (termStr.length() > TERM_SIZE) {
                termStr = termStr.substring(0, TERM_SIZE);
            } else {
                termSpaceSize = TERM_SIZE - termStr.length() + 1;
            }
            String termSpace = " ".repeat(termSpaceSize);
            String freqStr = String.valueOf(hashtable[i].getFreq());
            if(freqStr.length() > FREQ_SIZE) {
                freqStr = "OVER";
            }

            //May use when there are more than two columns
//            int freqSpace = 1;
//            if (freqStr.length() > FREQ_SIZE) {
//                freqStr = freqStr.substring(0, FREQ_SIZE);
//            } else {
//                freqSpace = FREQ_SIZE - freqStr.length() + 1;
//            }

            out.append(termStr).append(termSpace).append(freqStr).append("\n");
        }
        return out;

//        System.out.println("Collisions: "+collision+" Used: "+used+" Lookups: "+lookups);
    }

    /**
     * Insert string term, and int freq into hashtable, hashes on term.
     * @param term String to be hashed.
     * @param freq String
     */
    public void insert(String term, int freq)
    {
        int index = find(term);

        //if not already in the table, insert it
        if(hashtable[index].getFreq() == -1)
        {
            hashtable[index].setTerm(term);
            hashtable[index].setFreq(freq);
            used++;
        } else { //increment freq
            hashtable[index].freq++;
        }
    }

    /**
     * Returns the index of the word in the table, or the index of a free space
     * in the table.
     * @param str String to hash.
     * @return index of the word, or of free space in which to place the word.
     */
    private int find(String str)
    {
        long sum=0;
        long index;

        //add all the characters of the string together
        for(int i=0;i<str.length();i++)
            sum=(sum*19)+str.charAt(i); //multiply sum by 19 and add byte value of char

        if(sum < 0)				// If calculation of sum was negative, make it positive
            sum = sum * -1;

        index= sum%size;
        int index2 = (int) index;

        /*
         * check to see if the word is in that location
         * if not there, do linear probing until word is found\
         * or empty location found
         */
        while(!hashtable[index2].getTerm().equals(str) && hashtable[index2].getFreq() != -1)
        {
            index2++;
            collision++;
            if(index2 >= size)
                index2 = 0;
        }

        return index2;
    }

    /**
     * Returns the freq at the hashed location of term.
     * @param term String to be hashed.
     * @return freq in the table at the location of term.
     */
    public int getFreq(String term)
    {
        int index=find(term);
        lookups++;
        return hashtable[index].getFreq();
    }

    /**
     * Get the three statistics as a string.  Used, Collisions, and Lookups.
     * @return Used, Collisions, and Lookups as a string.
     */
    public String getUsage()
    {
        return "Used: "+used+" Collisions: "+collision+" Lookups: "+lookups;
    }

    /**
     * Get the amount in the table.
     * @return How full the table is. long
     */
    public long getUsed()
    {
        return used;
    }

    /**
     * Get the number of collisions.
     * @return How much you need to improve your hash function. long
     */
    public long getCollisions()
    {
        return collision;
    }

    /**
     * The number of lookups made.
     * @return long
     */
    public long getLookups()
    {
        return lookups;
    }

    /**
     * Gets the size of the array.
     * @return size, long
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Returns Node at location index.
     * @param index location in hashtable
     * @return Node at location index.
     */
    private Node getNode(int index)
    {
        return hashtable[index];
    }


    /**
     * Private class node to whole the actual data stored in the hashtable.
     * Provides standard accessor and mutator methods.
     */
    private class Node
    {
        private String term;
        private int freq;

        public Node(String term, int freq)
        {
            this.term = term;
            this.freq = freq;
        }

        public String getTerm()
        {
            return term;
        }

        public int getFreq()
        {
            return freq;
        }

        public void setTerm(String term)
        {
            this.term = term;
        }

        public void setFreq(int freq)
        {
            this.freq = freq;
        }
    }
}
