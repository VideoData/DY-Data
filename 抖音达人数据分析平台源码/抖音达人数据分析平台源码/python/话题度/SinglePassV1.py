
from pyhanlp import HanLP

HanLP.Config.ShowTermNature = False


class Document():

    def __init__(self, doc_id, content, features):
        self.doc_id = doc_id
        self.features = features  # 文本的特征，这里是分词结果
        self.content = content  # 原文


class Cluster():

    def __init__(self, cluster_id, center_doc_id):
        self.cluster_id = cluster_id  # 簇的id，用来从map中获取这个簇的信息
        self.center_doc_id = center_doc_id  # 核心文档的id，用来从map红获取这个文档的信息。为了减少文档信息的备份数量，簇里只存储这个
        self.members = [center_doc_id]  # 簇成员的id列表。由于只遍历一遍(这是single-pass的核心竞争力之一)，不存在重复的可能，这里使用list

    def add_doc(self, doc_id):
        self.members.append(doc_id)


# 一个简单的single-pass文本聚类算法
class SinglePassV1():

    def __init__(self):
        self.document_map = {}  # 存储文档信息，id-content结构。当然value也可以使用对象存储文档的其他信息。
        self.cluster_list = []  # 存储簇的信息，

    # 提取文本特征
    def get_words(self, text):
        words = HanLP.segment(text)
        words = list(map(str, words))
        return words

    # 输入文档列表，进行聚类。现实中，我们遇到的文档会带有id等信息，这里为了简单，只有文本内容，所以需要生成id,一遍存取。
    def fit(self, document_list):
        # 对文档进行预处理
        self.preprocess(document_list)
        self.clutering()

    def similar(self, cluster, document):
        cluster_feature = set(self.document_map[cluster.center_doc_id].features)
        document_feature = set(document.features)
        #         print(cluster_feature, document_feature)
        similarity = len(cluster_feature & document_feature) / len(cluster_feature | document_feature)
        if similarity > 0.2:
            return True
        else:
            return False

    def clutering(self):
        for doc_id in self.document_map:
            #             print(doc_id, self.document_map[doc_id])
            if_特立独行 = True
            for cluster in self.cluster_list:
                if self.similar(cluster, self.document_map[doc_id]):
                    cluster.add_doc(doc_id)
                    if_特立独行 = False
                    break
            if if_特立独行:
                new_cluser_id = "cluster_" + str(len(self.cluster_list))
                print(new_cluser_id)
                new_cluster = Cluster(new_cluser_id, doc_id)
                self.cluster_list.append(new_cluster)

    # 对所有文档分词，并生成id
    def preprocess(self, document_list):
        for i in range(len(document_list)):
            doc_id = "document_" + str(i)
            content = document_list[i]
            words = self.get_words(content)
            document = Document(doc_id, content, words)
            self.document_map[doc_id] = document

    # 打印所有簇的简要内容
    def show_clusters(self):
        for cluster in self.cluster_list:
            print(cluster.cluster_id, cluster.center_doc_id, cluster.members)


# if __name__ == '__main__':
#     docs = ["我爱北京天安门，天安门上太阳升。",
#             "我要开着火车去北京，看天安门升旗。",
#             "我们的家乡，在希望的田野上。",
#             "我的老家是一片充满希望的田野。"]
#     single_passor = SinglePassV1()
#     single_passor.fit(docs)
#     single_passor.show_clusters()