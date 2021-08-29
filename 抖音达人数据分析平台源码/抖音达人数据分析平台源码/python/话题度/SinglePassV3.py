import sys, os
import csv

path = os.path.dirname(os.getcwd())
sys.path.append(path)
from SinglePassV1 import SinglePassV1, Cluster, Document
from xml.dom.minidom import parse
import xml.dom.minidom
import re


# 增加倒排索引
class SinglePassV3(SinglePassV1):

    def __init__(self):
        self.document_map = {}  # 存储文档信息，id-content结构。当然value也可以使用对象存储文档的其他信息。
        self.cluster_map = {}  # 存储簇的信息，由于需要频繁查询，使用了map ， id-cluster_object结构。
        self.cluster_iindex = {}  # word-cluster_ids结构的倒排索引
        self.stopWords = []  # 停用词

    def clutering(self):
        for doc_id in self.document_map:
            #             print(doc_id, self.document_map[doc_id])
            words = self.document_map[doc_id].features
            if_特立独行 = True
            for cluster_id in self.get_cand_clusters(words):
                cluster = self.cluster_map[cluster_id]
                if self.similar(cluster, self.document_map[doc_id]):
                    cluster.add_doc(doc_id)
                    if_特立独行 = False
                    break
            if if_特立独行:
                new_cluser_id = "cluster_" + str(len(self.cluster_map))
                new_cluster = Cluster(new_cluser_id, doc_id)
                self.cluster_map[new_cluser_id] = new_cluster
                for word in self.document_map[new_cluster.center_doc_id].features:
                    if word not in self.cluster_iindex: self.cluster_iindex[word] = []
                    self.cluster_iindex[word].append(new_cluser_id)

    def get_cand_clusters(self, words):
        cand_cluster_ids = []
        for word in words:  # 这里只要有一个命中，就算是候选簇；如果文本较长，可以提升阈值
            cand_cluster_ids.extend(self.cluster_iindex.get(word, []))
        return cand_cluster_ids

    # 打印所有簇的简要内容
    def show_clusters(self):
        for cluster_id in self.cluster_map:
            cluster = self.cluster_map[cluster_id]
            print(cluster.cluster_id, cluster.center_doc_id, cluster.members)

    # 预处理
    def preprocess(self, document_list):
        for i in range(len(document_list)):
            doc_id = "document_" + str(i)
            content = document_list[i]
            words = self.get_words(content)
            # 除去停用词
            temp = []
            for word in words:
                if word not in self.stopWords:
                    temp.append(word)
            words = temp
            document = Document(doc_id, content, words)
            self.document_map[doc_id] = document

    # 读取停用词
    def readStopWord(self, path):
        with open(path, "r", encoding="utf-8") as f:
            self.stopWords = f.readlines()
            for i in range(self.stopWords.__len__()):
                self.stopWords[i] = self.stopWords[i].replace("\n", "")

    def clean(self):
        self.document_map = {}  # 存储文档信息，id-content结构。当然value也可以使用对象存储文档的其他信息。
        self.cluster_map = {}  # 存储簇的信息，由于需要频繁查询，使用了map ， id-cluster_object结构。
        self.cluster_iindex = {}  # word-cluster_ids结构的倒排索引


def readComment(path):
    commentsDict = {}
    comments = []
    try:
        data = open(path, "rb").read().decode("utf-8", "ignore")
        comments = data.split("-:")
    except Exception as e:
        print(e.msg)
    tempTitle = ''
    for comment in comments:
        try:
            comment = comment.replace("\n", "")
            if 'title' in comment:
                spliteTile = comment.split("title:")
                if 'replysNum:' in comment:
                    commentsDict[tempTitle]['replysNum'] = spliteTile[0].split('replysNum:')[1]
                    commentsDict[tempTitle]['comments'].append(spliteTile[0].split("replysNum:")[0])
                temp = {}
                temp['playnum'] = spliteTile[1].split('playnum:')[1]
                temp['comments'] = []
                title = spliteTile[1].split('playnum:')[0]
                commentsDict[title] = temp
                tempTitle = title
            else:
                commentsDict[tempTitle]['comments'].append(comment)
        except Exception as e:
            print(e.msg)
    return commentsDict


def test():
    path = "F:/apycharWorkSpace/studyten/douyin/topicRecongnization/stopWord.txt"
    DOMTree = xml.dom.minidom.parse("C:/Users/Administrator/Downloads/Compressed/ac/a.xml")
    collection = DOMTree.documentElement
    docs = collection.getElementsByTagName("doc")
    pattern = r',|\.|/|;|\'|`|\[|\]|\?|\{|\}|\~|!|@|#|\$|%|\^|&|\(|\)|-|=|\_|\+|。|；|【|】|·|！|…'
    for doc in docs:
        type = doc.getElementsByTagName('content')[0]
        text = type.childNodes[0].data
        result = re.split(pattern, text)
        for i in result:
            print(i)
        single_passor = SinglePassV3()
        single_passor.readStopWord(path)
        single_passor.fit(result)
        templength = -1
        temp = ''

        map = single_passor.cluster_map
        # temp = map[0].members
        for cluster_id in map:
            cluster = map[cluster_id]
        for id in single_passor.cluster_map:
            cluster = single_passor.cluster_map[id]
            if cluster.members.__len__() > templength:
                templength = cluster.members.__len__()
                temp = cluster
        print("----")
        for member in temp.members:
            test = single_passor.document_map[member]
            print(test.content)
        print("----")


if __name__ == '__main__':
    # test()
    commentsDict = readComment("D:/dy/临时数据2/commentOut4.txt")
    path = "F:/apycharWorkSpace/studyten/douyin/topicRecongnization/stopWord.txt"

    outpath = "C:/Users/Administrator/Desktop/抖音临时/topic2.csv"
    with open(outpath, 'w', newline='') as file:
        writer = csv.writer(file)
        for key in commentsDict.keys():
            single_passor = SinglePassV3()
            single_passor.readStopWord(path)
            single_passor.fit(commentsDict[key]['comments'])
            # single_passor.show_clusters()
            num = 0
            for cluster_id in single_passor.cluster_map:
                cluster = single_passor.cluster_map[cluster_id]
                if cluster.members.__len__() > 20:
                    num += 1
            writer.writerow([num,commentsDict[key]['playnum'],commentsDict[key]['comments'].__len__(),commentsDict[key]['replysNum']])
            print(num)
            single_passor.clean()
        print("ok")
