from sys import argv

import warnings
warnings.filterwarnings(action='ignore', category=UserWarning, module='gensim')

from gensim.models import Word2Vec

def load_word2vec():
    return Word2Vec.load('model')


def similar_words(query):

    query = query.split()

    model = load_word2vec()
    # print(type(model))

    q2 = []
    for word in query:
        q2.append(model.most_similar(word, topn=5))

    for lsts in q2:
        [query.append(word) for word, prob in lsts if prob > 0]
    return query

def main():
    query = ' '.join(argv[1:])
    query = similar_words(query)
    # print (query)

    f = open('expandedQuery.txt', 'w')
    for word in query:
        f.write(word)
        f.write(" ")
    f.close()

if __name__ == "__main__":
    main()
