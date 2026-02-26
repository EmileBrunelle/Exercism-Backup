class TwelveDays {
    String verse(int verseNumber) {
        if (verseNumber > 12) {
            throw new IllegalArgumentException("Verse number cannot be above 12.");
        }
        
        String[] numbers = {
            "first",
            "second",
            "third",
            "fourth",
            "fifth",
            "sixth",
            "seventh",
            "eighth",
            "ninth",
            "tenth",
            "eleventh",
            "twelfth"
        };
        String[] gifts = {
            " a Partridge in a Pear Tree.",
            " two Turtle Doves, and",
            " three French Hens,",
            " four Calling Birds,",
            " five Gold Rings,",
            " six Geese-a-Laying,",
            " seven Swans-a-Swimming,",
            " eight Maids-a-Milking,",
            " nine Ladies Dancing,",
            " ten Lords-a-Leaping,",
            " eleven Pipers Piping,",
            " twelve Drummers Drumming,",
        };

        var song = new StringBuilder("On the ");
        song.append(numbers[verseNumber - 1]);
        song.append(" day of Christmas my true love gave to me:");

        for (var i = verseNumber - 1; 0 <= i; --i) {
            song.append(gifts[i]);
        }
        
        song.append("\n");
        
        return song.toString();
    }

    String verses(int startVerse, int endVerse) {
        if (startVerse > endVerse) {
            throw new IllegalArgumentException("Start verse cannot be greater than the end verse.");
        }
        
        var song = new StringBuilder();

        for (var i = startVerse; i <= endVerse; ++i) {
            song.append(verse(i));

            if (i < endVerse) {
                song.append("\n");
            }
        }

        return song.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }
}