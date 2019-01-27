package dyd.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 *
 *
 *
 * Example 1:
 *
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 *
 * Note:
 *
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 */
public class Q00929_UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String uniqueEmail = receiveEmail(email);
            if (uniqueEmail.length() > 0 && !uniqueEmails.contains(uniqueEmail)) {
                uniqueEmails.add(uniqueEmail);
            }
        }
        return uniqueEmails.size();
    }

    private String receiveEmail(String email) {
        String[] names = email.split("@");
        if (names.length != 2) {
            return "";
        }

        String localName = names[0];
        String domainName = names[1];

        StringBuilder sb = new StringBuilder();
        boolean plus = false;
        for (int i = 0; i < localName.length(); i++) {
            char ch = localName.charAt(i);
            if (ch == '.') {
                continue;
            } else if (ch == '+') {
                plus = true;
                continue;
            } else if (plus) {
                continue;
            } else {
                sb.append(ch);
            }
        }
        sb.append('@');
        sb.append(domainName);
        return sb.toString();
    }

    public static void main(String[] args) {
        Q00929_UniqueEmailAddresses question = new Q00929_UniqueEmailAddresses();

        String[] emails = new String[] {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        System.out.println(question.numUniqueEmails(emails));

        emails = new String[] {"@"};
        System.out.println(question.numUniqueEmails(emails));
    }
}
