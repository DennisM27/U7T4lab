import java.util.ArrayList;

public class ArrayListAlgorithms {
    /**
     * Returns true if any of the elements in stringList contain
     * target as a substring; false otherwise.  Use indexOf instead of contains
     * for AP practice! (although in reality, contains is preferred)
     * <p>
     * Does NOT mutate (modify) elements of stringList.
     * PRECONDITION: stringList.size() > 0
     *
     * @param stringList original arraylist of Strings
     * @return true if target is found in any of the strings, false otherwise
     */
    public static boolean containsTarget(ArrayList<String> stringList, String target) {
        for (String string : stringList)
        {
            if (string.contains(target)) {
                return true;
            }
        }
        return false;
    }

    /** Returns number of elements in intList that are less than the
     *  average of all elements.
     *
     *  Does NOT mutate (modify) elements of intList.
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  original arraylist of Integers
     *  @return  the number of ints in intList that are less than the average
     */
    public static int belowAverage(ArrayList<Integer> intList)
    {
        int sum = intList.stream().mapToInt(a -> a).sum();
        double average = (double) sum / intList.size();
        int total = 0;
        for (int newIntList : intList)
        {
            if (newIntList < average)
            {
                total++;
            }
        }
        return total;
    }

    /** Replaces all words in wordList that end in "s" with the all-uppercase
     *  version of the word.  For example, "apples" should be replaced with "APPLES".
     *  Assume all letters of all words in wordList are lowercase initially (no need
     *  to worry about checking for case or converting first to lowercase)
     *
     *  DOES mutate (modify) elements of wordList.
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  original arraylist of words
     */
    public static void replaceWithCaps(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++)
        {
            String word = wordList.get(i);
            String lastLetter = word.substring(word.length() - 1);
            if (lastLetter.equals("s"))
            {
                String uppercaseLetter = word.toUpperCase();
                wordList.set(i, uppercaseLetter);
            }
        }
    }

    public static int indexOfMinimum(ArrayList<Integer> intList)
    {
        int minimum = intList.get(0);
        int index = 0;
        for (int i = 0; i < intList.size(); i++)
        {
            if (intList.get(i) < minimum)
            {
                minimum = intList.get(i);
                index = i;
            }
        }
        return index;
    }

    public static boolean areIdentical(ArrayList<Integer> numList1, ArrayList<Integer> numList2) {
        for (int i = 0; i < numList1.size(); i++) {
            if (!numList1.get(i).equals(numList2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void removeOdds(ArrayList<Integer> numList)
    {
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) % 2 == 0) {
                numList.remove(i);
                i--;
            }
        }
    }

    public static void wackyVowels(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (!word.contains("a") || !word.contains("e") || !word.contains("i") || !word.contains("o")) {
                wordList.remove(i);
                i--;
            }
        }
    }

    public static void removeDuplicates(ArrayList<Integer> intList)
    {
        ArrayList<Integer> log = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            if (log.contains(intList.get(i))) {
                intList.remove(i);
                i--;
            } else {
                log.add(intList.get(i));
            }
        }
    }

    public static void duplicateUpperAfter(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++) {
            wordList.add(i + 1, wordList.get(i).toUpperCase());
            i++;
        }
    }

    public static void duplicateUpperEnd(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++) {
            wordList.add(wordList.get(i).toUpperCase());
        }
    }

    public static ArrayList<String> parseWordsAndReverse(String sentence)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] array = sentence.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

    public static void moveBWords(ArrayList<String> wordList)
    {
        int currentB = 0;
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (word.startsWith("b")) {
                wordList.remove(i);
                wordList.add(currentB, word);
                currentB++;
            }
        }
    }

    public static ArrayList<Integer> modes(int[] numList)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int maxCount = 1;
        for (int i = 0; i < numList.length; i++) {
            int count = 1;
            for (int j = 0; j < numList.length; i++) {
                if (numList[i] == numList[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                arrayList.clear();
                arrayList.add(numList[i]);
            }
        }
        return arrayList;
    }
}