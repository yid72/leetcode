package dyd.leetcode.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
 * read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
public class QU_2 {
//    public List<String> findItinerary(List<List<String>> tickets) {
//        List<List<String>> jfkTickets = new ArrayList<>();
//        for (List<String> ticket : tickets) {
//            if (ticket.get(0).equals("JFK")) {
//                jfkTickets.add(ticket);
//            }
//        }
//
//
//        List<List<String>> results = new ArrayList<>();
//        for (List<String> ticket : jfkTickets) {
//            Map<String, List<String>> ajacents = buildAjacents(tickets);
//
//            List<String> result = new ArrayList<>();
//            results.add(result);
//
//            String from = ticket.get(0);
//            result.add(from);
//            dfs(from, ajacents, result);
//        }
//    }
//
//    private void dfs(String from, Map<String, List<String>> ajacents, List<List<String>> results, List<String> result) {
//
//        for (String to : ajacents.get(from)) {
//            result.add(to);
//            ajacents.get(from).remove(to);
//
//            dfs(to, ajacents, result);
//        }
//    }
//
//    private Map<String, List<String>> buildAjacents(List<List<String>> tickets) {
//        Map<String, List<String>> ajacents = new HashMap<>();
//        for (List<String> ticket : tickets) {
//            String from = ticket.get(0);
//            String to = ticket.get(1);
//            if (ajacents.containsKey(from)) {
//                ajacents.get(from).add(to);
//            } else {
//                List<String> tos = new ArrayList<>();
//                tos.add(to);
//                ajacents.put(from, tos);
//            }
//        }
//        return ajacents;
//    }
}
