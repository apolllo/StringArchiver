public class StringArchiver {
    public static void main(String[] args) {
        String s1 = "Heeeelllooooo World";
        String s2 = "Helllllllllllllo";
        System.out.println(archive(s1));
        System.out.println(archive(s2));
        System.out.println(archiveSimple(s1));
        System.out.println(archiveSimple(s2));
        System.out.println("Decoded " + decode(archive(s1)));
        System.out.println("Decoded " + decode(archive(s2)));
        System.out.println("Decoded simple: " + decode(archiveSimple(s1)));
        System.out.println("Decoded simple: " + decode(archiveSimple(s2)));
        System.out.println();
        System.out.println(archive("1l3b11"));
    }

    public static StringBuilder archive(String input) {
        if (input.matches(".*[0-9].*")) {
            System.out.println("Warn: StringArchiver will not be able to decode string containing numbers");
        }
        StringBuilder output = new StringBuilder("");
        while (input.length() > 0) {
            String firstChar = input.substring(0,1);
            String rest = input.replaceFirst(firstChar + "+", "");
            int count = input.length()-rest.length();
            if (count > 1) { output.append(count); }
            output.append(firstChar);
            input = rest;
        }
        return output;
    }

    public static StringBuilder archiveSimple(String input) {
        if (input.matches(".*[0-9].*")) {
            System.out.println("Warn: StringArchiver will not be able to decode string containing numbers");
        }
        StringBuilder output = new StringBuilder("");
        while (input.length() > 0) {
            String firstChar = input.substring(0,1);
            String rest = input.replaceFirst(firstChar + "{1,9}", "");
            int count = input.length()-rest.length();
            if (count > 1) { output.append(count); }
            output.append(firstChar);
            input = rest;
        }
        return output;
    }

    public static StringBuilder decode(StringBuilder input) {
        StringBuilder output = new StringBuilder("");
        while (input.length() > 0) {
            char firstChar = input.charAt(0);
            int count = 1;
            if (Character.isDigit(firstChar)) {
                String rest = input.toString().replaceFirst("[0-9]+", "");
                int countLength = input.length() - rest.length();
                count = Integer.parseInt(input.substring(0,countLength));
                input.delete(0,countLength);
            }
            for(int i=0; i<count; i++) {
                output.append(input.charAt(0));
            }
            input.deleteCharAt(0);
        }
        return output;
    }
}
