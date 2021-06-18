public class Palindrome {

    public static boolean isPalindrome(String s){

        int j = s.length()-1;

        for(int i=0;i<j;i++){

            if(s.contains(" -#@")&& s.charAt(i)==s.charAt(j)){
                j--;
            }
            else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a ecar";
        System.out.println(Palindrome.isPalindrome(s));
    }
}
