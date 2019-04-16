#algs4学习笔记
---
#union-find算法
union-find算法对应的API：

```java
public class UF
	UF(int N) 						//以整数标识初始化N个触电
	void union(int p,int q)			//在p和q之间添加一条连接
	int find(int p,int q)			//p所在的分量的标识符
	boolean connected(int p,int q)	//判断p和q是否在同一分量中，是返回true
	int count()						//连通分量的数量
```
两种算法的示意：[quick-find&quick-union](https://algs4.cs.princeton.edu/15uf/)  
1、quick-find算法，每次union操作都要数组中的 **N** 个元素，不适用于大型问题，线性级别，实现：

```java
public int find(int p){
	return id[p];
}

public void union(int p,int q){
	int pID = find(p);
	int qID = find(q);

	if(pID == qID){
		return;
	}

	for(int i = 0;i < N;i++){
		if(id[i] == pID){
			id[i] = qID;	
		}
	}

	count --;
}
```

2、加权quick-union算法（quick-union不考虑两棵树的大小），无需对同一分量的所有触电置为同一个id，find算法查找到连接指向自己的根触点，然后再归并两个分量的触点，加权quick-union保证将较小的树连接到较大的树上，logN级别，实现：

```java
public int find(int p){
        while( p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(size[pRoot] < size[qRoot]){
            parent[pRoot] = qRoot;
        }else{
            parent[qRoot] = pRoot;
        }

        count --;
        return;
    }
```
## 排序算法
这里时间复杂度包括比较和交换的次数，且假设比较和交换的成本相同

|算法 | 时间复杂度 |空间复杂度|稳定性|备注|
|:-----:|:------:|:-------:|:--:|:--:|
|冒泡排序|o(N²) = 1 + 2 + ... + N - 1|o(1)，负责每次交换的那个临时变量temp|稳定|每次循环将最大的数放到末尾|
|选择排序|o(N²) = 1 + 2 + ... + N - 1|o(1)，负责每次交换的那个临时变量temp|稳定|从i=0开始，将a[i]与右侧元素中的最小元素交换|
|插入排序|介于N和N²之间，最好情况只需比较无需交换，最坏情况每次比较都需要交换，对应N²/2次比较和N²/2次交换|o(1)，同选择排序|稳定|总是保证索引i左侧的元素有序，依次与左侧元素进行交换（如果需要）|
|希尔排序|NlgN 具体没定论|o(1)|改进的插入排序|
|快速排序|最好情况NlgN，平均情况1.39NlgN，最坏情况N²|lgN，递归调用sort所需的栈深度|不稳定（会出现交换时候对连续相同的数字将第一个的次序放到了最后）|每次将待排序列分割为两个独立部分，再分别排序|
|堆排序|NlgN|o(1)|每次先初始化堆有序，再进行交换、删除和sink操作|
|归并排序|NlgN|N，需要辅助数组aux|稳定|每次将数组均分为两半，相比快排数组长度不稳定的情况，这里始终保持了最好情况|

快速排序是最快的通用排序算法。

## 查找算法

符号表：二叉树、红黑树、散列表，符号表中不允许有重复的键  
散列表查找时间最优，常数级别，但要保证高效的散列函数  
二叉树结构更简单，红黑树则保证最坏情况下的性能且支持的操作更多