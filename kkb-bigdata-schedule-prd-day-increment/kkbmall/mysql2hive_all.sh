#!/bin/bash

APP_NAME="/kkb/code/spark/kkb-spark-framework-1.0-SNAPSHOT.jar"
APP_MAINCLASS="com.kkb.spark.batch.TestMysql2Hive"
FILENAME=$1
ETL_DATE=$2
FILEPATH="/kkb/code/spark/conf/$FILENAME"
JAVA_HOME="/kkb/install/jdk1.8.0_141"
DRIVER_MEM=1G
EXECUTOR_MEM=1G
EXECUTOR_CORE=1
EXECUTOR_NUM=1


CMD="spark-submit --master yarn  \
--deploy-mode cluster \
--class $APP_MAINCLASS  \
--jars $APP_NAME \
--files $FILEPATH \
--driver-class-path /kkb/code/spark/mysql-connector-java-5.1.27.jar \
--driver-memory $DRIVER_MEM \
--num-executors $EXECUTOR_NUM \
--executor-memory $EXECUTOR_MEM \
--executor-cores $EXECUTOR_CORE \
$APP_NAME $FILENAME  $ETL_DATE"

eval $CMD








陈院，您好。不好意思周末打扰您休息，我向您申请大数据部门或者我个人不再向傅总汇报。傅总那里我实在伺候不了了，他的管理能力和态度以及沟通能力，我是在无法与之配合。

我们大数据现在除了tsp的云端大数据业务，还要梳理整个自动驾驶的数据流程，同时调研小鹏、比亚迪、特斯拉等其它车厂的自动驾驶技术，我还一手组织着整个芯片的需求收集和与中兴的沟通，另外与朱帆总一直密切联系配合他的工作。但是在傅总眼里，总觉的我们大数据什么事都没做。

昨天，本来朱帆总让我参与百度标注的会议，提出数据方面的需求，因为前期我帮自动驾驶团队沟通过京东数科的标注的会议。这下好了，昨天的部门周会，傅总直接说我去开其他部门的会，是“跟屁虫”，说是因为我自己没事干，才把跟自动驾驶的会议工作写在周报上么，这些话，当着所有矩阵部门的人说的。
这几天的招聘也是，每周让我们推荐到他那里2个人，好，我推荐过去了，各种找理由不满意，说为什么没有车厂经验的，我说我们先解决人员有无的问题，碰到有车厂经验的，我们肯定会优先考虑。他直接说：“你做不来是么？ 我很担心这块业务你能否负责好。“。其它大大小小的事情不计其数，我实在是受不了了。

你可以去调研一下其它车联的人对他的评价，我这里不方便多说了。 既然他觉得我做不好，与其被他开除，还不如我先向您申请调换部门，如果还不行，那我就只能再想其它办法。

我对我的技术以及管理能力是很有信心的，包括我们现在整个大数据部门都在学习自动驾驶和芯片相关的内容，为了以后更好的做好自动驾驶和芯片的工作。只是碰到这样的领导，我没有办法。从我7月份入职开始，我已经忍了4个月了，实在忍不下去了，不好意思。

祝您周末愉快。