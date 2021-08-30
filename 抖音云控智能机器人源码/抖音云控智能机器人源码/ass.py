import chardet
import re


def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        pass

    try:
        import unicodedata
        unicodedata.numeric(s)
        return True
    except (TypeError, ValueError):
        pass

    return False


a = "\345\267\246\345\217\263pk\345\223\245\343\200\202"
print(a)

c = r'"Mr. \350\224\241kkkk\345\205\210\347\224\237 ??":{{::lll"'
clist = re.split(r'[" \\]', c)
print(clist)
clistg = []

for i in clist:
    if i != '':
        if len(i) > 3:
            clistg.append(i[0:3])
            clistg.append(i[3:])
        else:
            clistg.append(i)

print(clistg)

ad = []
t = ''
for i in range(len(clistg)):
    if is_number(clistg[i]):
        ad.append(clistg[i])
    else:
        pr = bytes([int(i, 8) for i in ad]).decode('utf-8')
        t = t + pr + clistg[i]
        ad.clear()

print(t)

# print(numlist)
# print(t)

# def getstr(s):
#     clist = re.split(r'[" \\]', s)
#     num_list = [int(i, 8) for i in clist if is_number(i)]
#     print(bytes(num_list).decode('utf-8'))


# dd = c.replace('\\', '')
# print(dd)

# print([ord(int(i)) for i in dd[1:]])


# print(ord(123))

# # a = bytes(a, encoding='utf-8')
# print([ord(c) for c in a])

#
# print(bytes([ord(c) for c in a]).decode())
#
#
# # fencoding = chardet.detect(a)  # 这行可以判断当前字符串的格式，以便后面设置打印字符的字符编码
# #
# # print(fencoding)
# # a = a.decode('utf-8')
# # print(a)
# print("".join("{:02x}".format(ord(c)) for c in "\016\f\016\031"))