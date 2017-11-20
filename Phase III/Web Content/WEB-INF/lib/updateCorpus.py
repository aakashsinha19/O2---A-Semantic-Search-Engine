from nltk.tokenize import word_tokenize, sent_tokenize

import warnings
warnings.filterwarnings(action='ignore', category=UserWarning, module='gensim')


from gensim.models import Word2Vec
from nltk.corpus import brown, movie_reviews, treebank

def make_word2vec():
    file_name = 'corpus.txt'
    with open(file_name) as f:
        data = f.read()
        # print(data)

    data = sent_tokenize(data)
    token = []
    for sent in data:
        token.append(word_tokenize(sent))

    model = Word2Vec(token, min_count=1)
    model.save('model')

    f = open('log.txt', 'w')
    f.write("Model Trained!")
    f.close()

def main ():
    make_word2vec ()

if __name__ == "__main__":
    main()
