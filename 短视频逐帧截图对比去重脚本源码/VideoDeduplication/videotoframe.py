import cv2
import os
#读入视频路径
inputdir="./video"
#输出图片路径
outputdir="./frame"
#间隔skip_frame帧截取一张图片
skip_frame=150
#生成帧截图数量
frameNum=0

#遍历整个视频,按间隔抽出帧并保存
#返回截图帧数量
def process_video(i_video, o_video, num):
    cap = cv2.VideoCapture(i_video)
    num_frame = cap.get(cv2.CAP_PROP_FRAME_COUNT)
    expand_name = '.jpg'
    if not cap.isOpened():
        print("Please check the path.")
    cnt = 0

    count = 0
    while 1:
        ret, frame = cap.read()
        
        if cnt % num == 0:
            count += 1
            save_dir=os.path.join(o_video, str(count) + expand_name)
            cv2.imwrite(save_dir, frame)
            print("Save frame : "+save_dir)
        cnt += 1
        if not ret:
            break
    return count

#图片相似度ORB
def ImgSimilarity(imgApath,imgBpath):
    #try:
    #读取图片
    img1 = cv2.imread(imgApath, cv2.IMREAD_GRAYSCALE)
    img2 = cv2.imread(imgBpath, cv2.IMREAD_GRAYSCALE)

    #初始化ORB检测器
    orb = cv2.ORB_create()
    kp1, des1 = orb.detectAndCompute(img1, None)
    kp2, des2 = orb.detectAndCompute(img2, None)

    #提取并计算特征点
    bf = cv2.BFMatcher(cv2.NORM_HAMMING)

    #knn筛选结果
    matches = bf.knnMatch(des1, trainDescriptors=des2, k=2)

    #查看最大匹配点数目
    good = [m for (m, n) in matches if m.distance < 0.75 * n.distance]
    #print(len(good))
    #print(len(matches))
    if(len(matches)==0):
        similary=0
        return similary
    similary = len(good) / len(matches)
    print("Similary between "+imgApath+" to "+imgBpath+"  =  "+str(similary))
    return similary
    """
    except:
        print("Can not campare similary between "+imgApath+" to "+imgBpath)
        return '0'
"""

#遍历所有截图去重
def DeleteSimilarImg(path,num):
    cnt=1
    i=1
    while(True):
        if(cnt>=num):
            return 0
        i=cnt+1
        while(True):
            #对比cnt.jpg和i.jpg
            imgA=os.path.join(outputdir,str(cnt)+".jpg")
            imgB=os.path.join(outputdir,str(i)+".jpg")
            if(ImgSimilarity(imgA,imgB)>=0.75):
                #删除重复图片i.jpg
                if os.path.exists(imgB):
                    print("Delete frame "+imgB)
                    os.remove(imgB)
                    i=i+1#cnt.jpg继续向后对比
                    if(i>num):
                        return 0
                else:
                    print("No such file")#文件不存在
            else:
                #两图片不同,cnt前进到i
                cnt=i
                break
                

if __name__ == '__main__':
    print("Video to frame--by ZhuQingzhang")
    print("Step 1:")
    print("Process the input video")
    videodir=os.path.join(inputdir,os.listdir(inputdir)[0])
    print(videodir)
    frameNum=process_video(videodir,outputdir,skip_frame)
    print("Extracting frames end")
    print("Produce frame -- "+str(frameNum))
    print("Step 2:")
    print("Delete the similar frame")
    DeleteSimilarImg(outputdir,frameNum)
    print("Duplicate removal end")
    
    
    