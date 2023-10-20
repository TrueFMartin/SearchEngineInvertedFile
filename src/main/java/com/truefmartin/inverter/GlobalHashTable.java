package com.truefmartin.inverter;

/**
 * Filename: GlobalHashTabe.java
 * Author: Susan Gauch, converted to java by Matt Miller, debugged by Patrick Anderson.
 *
 * Modified by: Franklin True Martin for use in inversion algorithm.
 */

import com.truefmartin.parser.HTMLParser;

import java.util.Arrays;

public class GlobalHashTable {

    /**
     * The type Hash table.
     */
    private int size;
    private long used;
    private long collision;
    private long lookups;
    private Node[] hashtable;

    private boolean hasFailed;

//    private final static int TERM_SIZE = HTMLParser.TERM_SIZE;
//    private final static int NUM_DOCS_SIZE = HTMLParser.FREQ_SIZE;

    /**
     * Initializes a hashtable with size 3 times the size given.
     *
     * @param size One third of the hashtable size;
     */
    public GlobalHashTable(int size)
    {
        this.size= (int) (size*3.01942);
        hasFailed = false;
        init();
    }

    /**
     * Copies a hashtable
     *
     * @param ht the ht
     */
    public GlobalHashTable(GlobalHashTable ht)
    {
        this.size=ht.getSize();
        used=ht.getUsed();
        collision=ht.getCollisions();
        lookups=ht.getLookups();
        hashtable=new Node[this.size];

        for(int i=0;i<this.size;i++)
            hashtable[i]=new Node(ht.getNode(i).getTerm(),ht.getNode(i).getNumDocs());
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
            hashtable[i]=new Node("empty",-1, -1);
    }

    /**
     * Gets num unique terms.
     *
     * @return the num unique terms
     */
    public int getNumUniqueTerms() {
        int numUnique = 0;
        for (Node node: hashtable) {
            if (node.numDocs != -1) {
                numUnique++;
            }
        }
        return numUnique;
    }

    /**
     * Prints the contents of the hashtable to the file given.
     *
     * @return StringBuilder of hash table with empty fields
     */
//    public StringBuilder print()
//    {
//
//        StringBuilder out = new StringBuilder(size*20);
//
//        for(int i=0;i<size;i++)
//        {
//
//            String termStr = hashtable[i].getTerm();
//            int termSpaceSize = 1;
//            if (termStr.length() > TERM_SIZE) {
//                termStr = termStr.substring(0, TERM_SIZE);
//            } else {
//                termSpaceSize = TERM_SIZE - termStr.length() + 1;
//            }
//            String termSpace = " ".repeat(termSpaceSize);
//            String numDocsStr = String.valueOf(hashtable[i].getNumDocs());
//            if(numDocsStr.length() > NUM_DOCS_SIZE) {
//                numDocsStr = "OVER";
//            }
//
//            //May use when there are more than two columns
////            int numDocsSpace = 1;
////            if (numDocsStr.length() > FREQ_SIZE) {
////                numDocsStr = numDocsStr.substring(0, FREQ_SIZE);
////            } else {
////                numDocsSpace = FREQ_SIZE - numDocsStr.length() + 1;
////            }
//
//            out.append(termStr).append(termSpace).append(numDocsStr).append("\n");
//        }
//        return out;
//
////        System.out.println("Collisions: "+collision+" Used: "+used+" Lookups: "+lookups);
//    }


    /**
     * Sort and remove all empty buckets.
     *
     * @return the string builder
     */
    public StringBuilder printSorted()
    {
        StringBuilder out = new StringBuilder(size*20);
        Arrays.stream(this.hashtable).filter(node -> node.getNumDocs() != -1).sorted().forEachOrdered(out::append);
        return out;
    }

    /**
     * Insert string term, and int numDocs into hashtable, hashes on term.
     *
     * @param term String to be hashed.
     * @param numDocs String
     */
    public void insert(String term, int numDocs)
    {
        int index = find(term);

        //if not already in the table, insert it
        if(hashtable[index].getNumDocs() == -1)
        {
            hashtable[index].setTerm(term);
            hashtable[index].setNumDocs(numDocs);
            used++;
        } else { //increment numDocs
            hashtable[index].numDocs++;
        }
    }


    /**
     * Insert string term, and int numDocs into hashtable, hashes on term.
     *
     * @param term String to be hashed.
     * @param numDocs String
     */
    public void insert(String term, int numDocs, int start)
    {
        int index = find(term);

        //if not already in the table, insert it
        if(hashtable[index].getNumDocs() == -1)
        {
            hashtable[index].setTerm(term);
            hashtable[index].setNumDocs(numDocs);
            hashtable[index].setStart(start);
            used++;
        } else { //increment numDocs
            hashtable[index].numDocs++;
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

        int index = Math.abs(str.hashCode())%size;
        boolean onSecondLoop = false;
        /*
         * check to see if the word is in that location
         * if not there, do linear probing until word is found\
         * or empty location found
         */
        while(!hashtable[index].getTerm().equals(str) && hashtable[index].getNumDocs() != -1)
        {
            index++;
            collision++;
            if(index >= size) {
                index = 0;
                if(onSecondLoop) {
                    hasFailed = true;
                    break;
                }
                onSecondLoop = true;
            }
        }

        return index;
    }

    public boolean setStart(String term, int start) {
        int index = find(term);
        if (hashtable[index].getNumDocs() == -1)
            return false;
        hashtable[index].setStart(start);
        return true;
    }

    /**
     * Returns the numDocs at the hashed location of term.
     *
     * @param term String to be hashed.
     * @return numDocs in the table at the location of term.
     */
    public int getNumDocs(String term)
    {
        int index=find(term);
        lookups++;
        return hashtable[index].getNumDocs();
    }

    /**
     * Get the three statistics as a string.  Used, Collisions, and Lookups.
     *
     * @return Used, Collisions, and Lookups as a string.
     */
    public String getUsage()
    {
        return "Used: "+used+" Collisions: "+collision+" Lookups: "+lookups;
    }

    /**
     * Get the amount in the table.
     *
     * @return How full the table is. long
     */
    public long getUsed()
    {
        return used;
    }

    /**
     * Get the number of collisions.
     *
     * @return How much you need to improve your hash function. long
     */
    public long getCollisions()
    {
        return collision;
    }

    /**
     * The number of lookups made.
     *
     * @return long lookups
     */
    public long getLookups()
    {
        return lookups;
    }

    /**
     * Gets the size of the array.
     *
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
     * Has failed boolean.
     *
     * @return the boolean
     */
    public boolean hasFailed() {
        return hasFailed;
    }


    /**
     * Private class node to whole the actual data stored in the hashtable.
     * Provides standard accessor and mutator methods.
     */
    private class Node implements Comparable<Node>
    {
        private String term;
        private int numDocs;


        private int start;

        /**
         * Instantiates a new Node.
         *
         * @param term the term
         * @param numDocs the numDocs
         */
        public Node(String term, int numDocs)
        {
            this.term = term;
            this.numDocs = numDocs;
        }

        /**
         * Instantiates a new Node with start.
         *
         * @param term the term
         * @param numDocs the numDocs
         * @param start the start in the postings file
         */
        public Node(String term, int numDocs, int start)
        {
            this.term = term;
            this.numDocs = numDocs;
            this.start = start;
        }
        /**
         * Gets term.
         *
         * @return the term
         */
        public String getTerm()
        {
            return term;
        }

        /**
         * Gets numDocs.
         *
         * @return the numDocs
         */
        public int getNumDocs()
        {
            return numDocs;
        }

        /**
         * Sets term.
         *
         * @param term the term
         */
        public void setTerm(String term)
        {
            this.term = term;
        }

        /**
         * Sets numDocs.
         *
         * @param numDocs the numDocs
         */
        public void setNumDocs(int numDocs)
        {
            this.numDocs = numDocs;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        @Override
        public String toString() {
            return this.term + " " + this.numDocs + " " + start + "\n";
        }

        @Override
        public int compareTo(Node node) {
            if (this.numDocs == -1 && node.numDocs == -1)
                return 0;
            return this.numDocs == -1 ? 1: this.term.compareTo(node.term);
        }
    }
}


