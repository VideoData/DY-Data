# coding=utf-8
import csv
import numpy as np
from sklearn.naive_bayes import GaussianNB
import os
import json


# futureData  :总获赞  关注数 粉丝数 作品  动态  喜欢  有签名？
# 贝叶斯
def train(futureData, labelData):
    X = np.array(futureData)
    y = np.array(labelData)
    clf = GaussianNB()  # 默认priors=None
    clf.fit(X, y)
    return clf


# 获取打标签的数据csv
def get_csv(path):
    futureData = []
    labelData = []
    with open(path, encoding='gbk')as f:
        f_csv = csv.reader(f)
        i = 0
        for row in f_csv:
            if i == 0:
                i = 1
                continue
            temp = row[3:10]
            for i in range(len(temp)):
                temp[i] = int(temp[i])
            futureData.append(temp)
            if row[1] == '':
                labelData.append(0)
            else:
                labelData.append(int(row[1]))
    return futureData, labelData


# 解析W
def parseW(s):
    if 'w' in s:
        return float(s.replace('w', '')) * 10000
    else:
        return float(s)


def main():
    file_dir = r'D:/唐/input/'
    fans_list = []
    fans_json = {}
    file_path = 'D:/唐/output/4410839599430167.json'
    json_input_str = ''
    with open(file_path, 'r', encoding='utf-8') as input_file:
        lines = input_file.readlines()
        for line in lines:
            json_input_str += line.strip()
    # json_input_str +=
    jsons = json.loads(json_input_str)
    predictData = []
    for key, value in jsons.items():
        temp = []
        temp.append(parseW(value["like"]))
        temp.append(parseW(value["follow_count"]))
        temp.append(parseW(value["fans"]))
        temp.append(parseW(value["work"]))
        temp.append(parseW(value["work"]))
        temp.append(parseW(value["love"]))
        if len(value["describe"]) > 3:
            temp.append(1)
        else:
            temp.append(0)
        predictData.append(temp)

    # print(predictData)
    futureData, labelData = get_csv("D:/唐/真假粉判断标注.csv")
    clf = train(futureData, labelData)
    result = clf.predict(predictData)

    n = 0
    for i in range(len(result)):
        n += result[i]
        print(predictData[i])
        print(result[i])
    print(n / len(result))



def main2():
    # 获取已标注的数据
    futureData, labelData = get_csv("F:/apycharWorkSpace/studyten/douyin/test4/真假粉判断标注.csv")
    # 训练
    clf = train(futureData, labelData)
    # 获取待预测的数据
    file_dir = r'D:/dy/临时数据/'
    # 预测结果输出
    resultdata = []
    resultdata.append(["id", "总检测粉丝数", "有效粉丝数", "比例"])
    for root, dirs, files in os.walk(file_dir):
        for file in files:
            # 排除csv文件
            if "fans" not in file:
                continue
            # 文件内容
            json_input_str = ''
            filename = file.split('.')[0]
            predictData = []
            reducedata = []  # 过滤nick判断
            csvoutdata = []
            with open(file_dir + file, 'r', encoding='utf-8') as input_file:
                f_csv = csv.reader(input_file)
                for line in f_csv:
                    if line.__len__() < 1:
                        continue
                    temp = []
                    temp.append(int(line[3]))
                    temp.append(int(line[4]))
                    temp.append(int(line[5]))
                    temp.append(int(line[6]))
                    temp.append(int(line[7]))
                    temp.append(int(line[8]))
                    temp.append(int(line[9]))
                    predictData.append(temp)
                    csvoutdata.append(temp)

            #     预测
            result = clf.predict(predictData)
            n = 0
            zhensum = 0
            print(result)
            for i in range(result.__len__()):
                print(result[i])
                zhensum += result[i]
            #     统计
            allsum = predictData.__len__()
            rate = (allsum - zhensum) / allsum
            filename = filename.replace("fans_", "")
            resultdata.append([filename, allsum, zhensum, rate])
            print([filename, allsum, zhensum, rate])
            # 写出
    print(resultdata)
    with open("D:/dy/临时数据/result.csv", 'w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)
        writer.writerows(resultdata)


#     数据分组
def split(futureData, labelData):
    print(len(futureData))
    split_point = int((len(futureData) * 8) / 10)
    XfutureData = futureData[0:split_point]
    XlabelData = labelData[0:split_point]
    YfutureData = futureData[split_point:len(futureData)]
    YlabelData = labelData[split_point:len(futureData)]
    return XfutureData, XlabelData, YfutureData, YlabelData




# 修复json数据格式
def fixdata():
    file_dir = r'D:/唐/待获取粉丝信息/out/'
    for root, dirs, files in os.walk(file_dir):
        for file in files:
            if "csv" in file:
                continue
            json_input_str = ''
            filename = file.split('.')[0]
            with open(file_dir + file, 'r', encoding='utf-8') as input_file:
                lines = input_file.readlines()
                for line in lines:
                    json_input_str += line.strip()
                input_file.close()
            json_input_str = json_input_str.replace("}}{", "},")
            json_input_str = json_input_str.replace("},}", "}}")
            json_input_str = json_input_str.replace("},{", "},")
            with open(file_dir + file, 'w', encoding='utf-8') as input_file:
                input_file.write(str(json_input_str))
                input_file.flush()
                input_file.close()


def judgeByNickname():
    file_dir = r'C:/Users/Administrator/Desktop/抖音临时/做图表/second/othre'
    # 预测结果输出
    resultdata = []
    resultdata.append(["id", "总检测粉丝数", "有效粉丝数", "比例"])
    for root, dirs, files in os.walk(file_dir):
        for file in files:
            # 排除csv文件
            if "csv" not in file:
                continue
            # 文件内容
            failnum = 0
            sum = 0
            with open(file_dir + '/' + file, 'r', encoding="utf-8") as input_file:
                f_csv = csv.reader(input_file)
                for row in f_csv:
                    sum += 1
                    nickname = row[1]
                    if "已重置" in nickname:
                        failnum += 1
                    elif "用户" in nickname:
                        failnum += 1
            print(file, failnum / sum)


if __name__ == '__main__':
    # main()
    main2()
    # judgeByNickname()
