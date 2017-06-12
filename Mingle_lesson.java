/**
Minglish lesson
===============
Welcome to the lab, minion. Henceforth you shall do the bidding of Professor
Boolean. Some say he's mad, trying to develop a zombie serum and all... but we
think he's brilliant!
First things first - Minions don't speak English, we speak Minglish. Use the
Minglish dictionary to learn! The first thing you'll learn is how to use the
dictionary.
Open the dictionary. Read the page numbers, figure out which pages come before
others. You recognize the same letters used in English, but the order of letters
is completely different in Minglish than English (a < b < c < ...).
Given a sorted list of dictionary words (you know they are sorted because you
can read the page numbers), can you find the alphabetical order of the Minglish
alphabet?
For example, if the words were ["z", "yx", "yz"] the alphabetical order would be
"xzy," which means x < z < y. The first two words tell you that z < y, and the
last two words tell you that x < z.
Write a function answer(words) which, given a list of words sorted
alphabetically in the Minglish alphabet, outputs a string that contains each
letter present in the list of words exactly once; the order of the letters in
the output must follow the order of letters in the Minglish alphabet.
The list will contain at least 1 and no more than 50 words, and each word will
consist of at least 1 and no more than 50 lowercase letters [a-z].
It is guaranteed that a total ordering can be developed from the input provided,
(i.e. given any two distinct letters, you can tell which is greater),
and so the answer will exist and be unique.
"""
**/


//def createGraph(words):
//    graph = {}
//    rows = len(words)
//    for row in range(rows - 1):
//        edge = find_edge(words[row], words[row + 1])
//
//        if edge is not None:
//            node, direction = edge
//            if node in graph:
//                graph[node].append(direction)
//            else:
//                graph[node] = [direction]
//    return graph
//
//
//def find_edge(a, b):
//    length = min(len(a), len(b))
//    for c in range(length):
//        if a[c] != b[c]:
//            return a[c], b[c]
//
//
//def start_nodes(graph):
//    tmp = set()
//    for edges in graph.values():
//        for edge in edges:
//            tmp.add(edge)
//    secondtmp = set()
//    for node in graph:
//        if node not in tmp:
//            secondtmp.add(node)
//    return secondtmp
//
//def answer(words):
//    graph = createGraph(words)
//    start = start_nodes(graph)
//    letters = []
//    traversed = []
//    def visit(node):
//        if node not in traversed:
//            traversed.append(node)
//
//            if node in graph:
//                for edge in graph[node]:
//                    visit(edge)
//            letters.append(node)
//
//    for node in start:
//        visit(node)
//    return ''.join(letters[::-1])