/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : dcctest

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2014-08-20 20:22:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bc_b_subject`
-- ----------------------------
DROP TABLE IF EXISTS `bc_b_subject`;
CREATE TABLE `bc_b_subject` (
  `SUBJECT_ID` varchar(32) NOT NULL COMMENT '自动设置',
  `SUBJECT_DESC` varchar(256) default NULL,
  `SUBJECT_TREE_CODE` varchar(128) default NULL,
  `STANDARD` int(11) default NULL COMMENT '1-标准 2-自定义',
  `SUBJECT_CODE` varchar(128) default NULL,
  `SUBJECT_NAME` varchar(128) default NULL,
  `SUBJECT_NAME_EN` varchar(128) default NULL,
  `SUBJECT_TYPE` int(11) default NULL COMMENT '1-主要分类法 2-其他分类法',
  `SUBJECT_ORDER` int(11) default NULL,
  `SUBJECT_PARENT_ID` varchar(32) default NULL,
  PRIMARY KEY  (`SUBJECT_ID`),
  KEY `FK7A54DFD159FFDBF0` (`SUBJECT_PARENT_ID`),
  CONSTRAINT `FK7A54DFD159FFDBF0` FOREIGN KEY (`SUBJECT_PARENT_ID`) REFERENCES `bc_b_subject` (`SUBJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_b_subject
-- ----------------------------
INSERT INTO `bc_b_subject` VALUES ('086341f07b1f1030a8ee2610e0325a2b', null, '001016016001', null, 'Q-0', '生物科学的理论与方法', 'Theory and Methodology of Bioscience', '1', '1', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086344447b1f1030a8ee2610e0325a2b', null, '001016016002', null, 'Q-05', '生物科学与其它科学的关系', 'The Relationship of  Bioscience and Other Sciences', '1', '2', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('0863452a7b1f1030a8ee2610e0325a2b', null, '001016016003', null, 'Q-1', '生物科学现状与发展', 'Current Situation and Development of Bioscience', '1', '3', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086345fb7b1f1030a8ee2610e0325a2b', null, '001016016004', null, 'Q-2', '生物研究机构、会议与生物机构名录', 'Directory of Biological Research Institutes , Conferences , and Biological Agencies', '1', '4', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086346cd7b1f1030a8ee2610e0325a2b', null, '001016016005', null, 'Q-3', '生物科学的研究方法与技术', 'Research Methods and Techniques of Bioscience', '1', '5', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086347927b1f1030a8ee2610e0325a2b', null, '001016016006', null, 'Q-4', '生物科学教育与普及', 'Disseminate and Study of Bioscience', '1', '6', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086348537b1f1030a8ee2610e0325a2b', null, '001016016007', null, 'Q-6', '生物科学工具书', 'Reference Books of Bioscience', '1', '7', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086349147b1f1030a8ee2610e0325a2b', null, '001016016008', null, 'Q-9', '生物资源调查', 'Biological Resources Survey', '1', '8', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086349e67b1f1030a8ee2610e0325a2b', null, '001016016009', null, 'Q1', '普通生物学', 'General Biology', '1', '9', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('08634aab7b1f1030a8ee2610e0325a2b', null, '001016016010', null, 'Q2', '细胞生物学', 'Cytobiology', '1', '10', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086384747b1f1030a8ee2610e0325a2b', null, '001016016011', null, 'Q3', '遗传学', 'Genetics', '1', '11', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086387167b1f1030a8ee2610e0325a2b', null, '001016016012', null, 'Q4', '生理学', 'Physiology', '1', '12', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086387f07b1f1030a8ee2610e0325a2b', null, '001016016013', null, 'Q5', '生物化学', 'Biochemistry', '1', '13', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086388c27b1f1030a8ee2610e0325a2b', null, '001016016014', null, 'Q6', '生物物理学', 'Biophysics', '1', '14', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086389937b1f1030a8ee2610e0325a2b', null, '001016016015', null, 'Q7', '分子生物学', 'Molecular Biology', '1', '15', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('08638a5d7b1f1030a8ee2610e0325a2b', null, '001016016016', null, 'Q81', '生物工程学(生物技术)', 'Bioengineering ( Biotechnology )', '1', '16', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086390137b1f1030a8ee2610e0325a2b', null, '001016016017', null, 'Q89', '环境生物学', 'Environmental Biology', '1', '17', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086391337b1f1030a8ee2610e0325a2b', null, '001016016018', null, 'Q91', '古生物学', 'Paleontology', '1', '18', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086392197b1f1030a8ee2610e0325a2b', null, '001016016019', null, 'Q93', '微生物学', 'Microbiology', '1', '19', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086392f37b1f1030a8ee2610e0325a2b', null, '001016016020', null, 'Q94', '植物学', 'Botany', '1', '20', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086393c07b1f1030a8ee2610e0325a2b', null, '001016016021', null, 'Q95', '动物学', 'Zoology', '1', '21', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086394867b1f1030a8ee2610e0325a2b', null, '001016016022', null, 'Q96', '昆虫学', 'Entomology', '1', '22', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('086395577b1f1030a8ee2610e0325a2b', null, '001016016023', null, 'Q98', '人类学', 'Anthropology', '1', '23', 'a468be697b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('111e0eb37b201030a8ee2610e0325a2b', null, '001020020001', null, 'U-6', '交通运输', 'Transportation', '1', '1', 'a468c76a7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('111e11487b201030a8ee2610e0325a2b', null, '001020020002', null, 'U-9', '交通运输经济', 'Transportation Economic', '1', '2', 'a468c76a7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('111e11d47b201030a8ee2610e0325a2b', null, '001020020003', null, 'U1', '综合运输', 'Integrated Transport', '1', '3', 'a468c76a7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('111e12547b201030a8ee2610e0325a2b', null, '001020020004', null, 'U2', '铁路运输', 'Rail Transport', '1', '4', 'a468c76a7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('111e12c77b201030a8ee2610e0325a2b', null, '001020020005', null, 'U4', '公路运输', 'Road Transport', '1', '5', 'a468c76a7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('111e133a7b201030a8ee2610e0325a2b', null, '001020020006', null, 'U6', '水路运输', 'Waterway Transport', '1', '6', 'a468c76a7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('111e13a47b201030a8ee2610e0325a2b', null, '001020020007', null, 'U8', '航空运输', 'Air Transport', '1', '7', 'a468c76a7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc147a77b1c1030a8ee2610e0325a2b', null, '001003003001', null, 'C-6', '社会科学总论工具书', 'Reference Books of Social Sciences Pandect ', '1', '1', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc149107b1c1030a8ee2610e0325a2b', null, '001003003002', null, 'C0', '社会科学理论与方法论', 'Social Science Theory and Methodology', '1', '2', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc149a07b1c1030a8ee2610e0325a2b', null, '001003003003', null, 'C1', '社会科学现状及发展', 'Current Situation and Development of Social Science', '1', '3', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14a137b1c1030a8ee2610e0325a2b', null, '001003003004', null, 'C2', '社会科学机构、团体、会议', 'Organizations, Groups , Conference of Social science', '1', '4', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14a827b1c1030a8ee2610e0325a2b', null, '001003003005', null, 'C3', '社会科学研究方法', 'Social Science Research Methods', '1', '5', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14af57b1c1030a8ee2610e0325a2b', null, '001003003006', null, 'C4', '社会科学教育与普及', 'Disseminate and Study of Social Science', '1', '6', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14b687b1c1030a8ee2610e0325a2b', null, '001003003007', null, 'C5', '社会科学丛书、文集、连续性出版物', 'Books , Collected Works , Series of Social Science ', '1', '7', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14bcf7b1c1030a8ee2610e0325a2b', null, '001003003008', null, 'C6', '社会科学参考工具书', 'Reference Books of Social Science ', '1', '8', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14c3a7b1c1030a8ee2610e0325a2b', null, '001003003009', null, 'C7', '社会科学文献检索工具书', 'Reference Books of Social Science Literature Searching ', '1', '9', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14ca97b1c1030a8ee2610e0325a2b', null, '001003003010', null, 'C8', '统计学', 'Statistics', '1', '10', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14d0f7b1c1030a8ee2610e0325a2b', null, '001003003011', null, 'C91', '社会学', 'Sociology', '1', '11', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14d727b1c1030a8ee2610e0325a2b', null, '001003003012', null, 'C92', '人口学', 'Demographic', '1', '12', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14dd57b1c1030a8ee2610e0325a2b', null, '001003003013', null, 'C93', '管理学', 'Management', '1', '13', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14e3b7b1c1030a8ee2610e0325a2b', null, '001003003014', null, 'C94', '系统科学', 'Systems Science', '1', '14', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14e9e7b1c1030a8ee2610e0325a2b', null, '001003003015', null, 'C95', '民族学', 'Ethnology', '1', '15', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14f017b1c1030a8ee2610e0325a2b', null, '001003003016', null, 'C96', '人才学', 'Science of Personnel', '1', '16', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('1cc14f637b1c1030a8ee2610e0325a2b', null, '001003003017', null, 'C97', '劳动科学', 'Labor Science', '1', '17', 'a468b3397b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('2c9080863ab97aa0013ab985215c0000', null, '001', null, 'CLC', '中图分类法', 'CLC', '1', '1', null);
INSERT INTO `bc_b_subject` VALUES ('2c90808944aae2cd0144aaf78dc90001', null, '002', '2', 'AUDIO', '音像制品分类', 'AUDIO_SUBJECT', '2', '1', null);
INSERT INTO `bc_b_subject` VALUES ('2c90808944aae2cd0144aaf84e860002', null, '002001', '2', 'A', '瑜伽系列 ', '瑜伽系列 ', '2', '1', '2c90808944aae2cd0144aaf78dc90001');
INSERT INTO `bc_b_subject` VALUES ('2edf295b7b1d1030a8ee2610e0325a2b', null, '001007007001', null, 'G-6', '文化、科学、教育、体育工具书', 'Reference Books of Culture, Science , Education, Sports', '1', '1', 'a468b85c7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('2edf2b857b1d1030a8ee2610e0325a2b', null, '001007007002', null, 'G0', '文化理论', 'Cultural Theory', '1', '2', 'a468b85c7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('2edf2c7c7b1d1030a8ee2610e0325a2b', null, '001007007003', null, 'G1', '世界各国文化与文化事业', 'The World Culture and Culture Industy', '1', '3', 'a468b85c7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('2edf2d627b1d1030a8ee2610e0325a2b', null, '001007007004', null, 'G2', '信息与知识传播', 'Dissemination of Information and Knowledge', '1', '4', 'a468b85c7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('2edf2e487b1d1030a8ee2610e0325a2b', null, '001007007005', null, 'G3', '科学、科学研究', 'Science , Scientific Research', '1', '5', 'a468b85c7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('2edf2f327b1d1030a8ee2610e0325a2b', null, '001007007006', null, 'G4', '教育', 'Educion', '1', '6', 'a468b85c7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('2edf2ffc7b1d1030a8ee2610e0325a2b', null, '001007007007', null, 'G8', '体育', 'P.E', '1', '7', 'a468b85c7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750d6587b1d1030a8ee2610e0325a2b', null, '001008008001', null, 'H-6', '语言、文字工具书', 'Reference Books of Language and Linguistics ', '1', '1', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750d8357b1d1030a8ee2610e0325a2b', null, '001008008002', null, 'H0', '语言学', 'Linguistics', '1', '2', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750d90b7b1d1030a8ee2610e0325a2b', null, '001008008003', null, 'H1', '汉语', 'Chinese Language', '1', '3', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750d9c87b1d1030a8ee2610e0325a2b', null, '001008008004', null, 'H2', '中国少数民族语言', 'Chinese Minority Languages', '1', '4', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750dab27b1d1030a8ee2610e0325a2b', null, '001008008005', null, 'H3', '常用外国语', 'Common Foreign Languages', '1', '5', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750db6b7b1d1030a8ee2610e0325a2b', null, '001008008006', null, 'H4', '汉藏语系', 'Sino-Tibetan', '1', '6', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750dc177b1d1030a8ee2610e0325a2b', null, '001008008007', null, 'H4/H95', '其他外国语', 'Other Foreign Languages', '1', '7', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750fd1c7b1d1030a8ee2610e0325a2b', null, '001008008008', null, 'H5', '阿尔泰语系（突厥-蒙古-通古斯语系）', 'Altaic(Turkic - Mongolian - Tungusic)', '1', '8', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750fe1b7b1d1030a8ee2610e0325a2b', null, '001008008009', null, 'H61', '南亚语系（澳斯特罗-亚细亚语系）', 'Austro-Asiatic', '1', '9', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750fec77b1d1030a8ee2610e0325a2b', null, '001008008010', null, 'H62', '南印语系（达罗毗荼语系、德拉维达语系）', 'South India Language(Dravidian,De la Vader)', '1', '10', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3750ff787b1d1030a8ee2610e0325a2b', null, '001008008011', null, 'H63', '南岛语系（马来亚-玻里尼西亚语系）', 'Austronesian', '1', '11', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375100257b1d1030a8ee2610e0325a2b', null, '001008008012', null, 'H64', '东北亚诸语言', 'Northeast Asia Languages', '1', '12', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375100cd7b1d1030a8ee2610e0325a2b', null, '001008008013', null, 'H65', '高加索语系（伊比利亚-高加索语系）', 'Caucasian Languages(Iberian - Caucasian Languages)', '1', '13', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('3751017a7b1d1030a8ee2610e0325a2b', null, '001008008014', null, 'H66', '乌拉尔语系（芬兰-乌戈尔语系）', 'Uralic', '1', '14', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375102227b1d1030a8ee2610e0325a2b', null, '001008008015', null, 'H67', '闪-含语系（阿非罗-亚细亚语系）', 'Semito-Hamitic', '1', '15', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375102cb7b1d1030a8ee2610e0325a2b', null, '001008008016', null, 'H7', '印欧语系', 'Indo-European Languages', '1', '16', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375103777b1d1030a8ee2610e0325a2b', null, '001008008017', null, 'H81', '非洲诸语言', 'African Languages', '1', '17', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375104207b1d1030a8ee2610e0325a2b', null, '001008008018', null, 'H83', '美洲诸语言', 'Americas Languages ​​', '1', '18', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375104c47b1d1030a8ee2610e0325a2b', null, '001008008019', null, 'H84', '大洋洲诸语言', 'Oceania Languages', '1', '19', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('375105717b1d1030a8ee2610e0325a2b', null, '001008008020', null, 'H9', '国际辅助语', 'International Auxiliary Language', '1', '20', 'a468b96b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7afd7b1c1030a8ee2610e0325a2b', null, '001004004001', null, 'D-6', '政治、法律工具书', 'Reference Books of Political，Law', '1', '1', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7c837b1c1030a8ee2610e0325a2b', null, '001004004002', null, 'D0', '政治理论', 'Political Theory', '1', '2', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7d0f7b1c1030a8ee2610e0325a2b', null, '001004004003', null, 'D1', '国际共产主义运动', 'The International Communist Movement', '1', '3', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7d8a7b1c1030a8ee2610e0325a2b', null, '001004004004', null, 'D1/D3', '共产主义运动、共产党', 'Communist Movement , The Communist Party', '1', '4', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7e057b1c1030a8ee2610e0325a2b', null, '001004004005', null, 'D2', '中国共产党', 'Communist Party of China', '1', '5', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7e7d7b1c1030a8ee2610e0325a2b', null, '001004004006', null, 'D33/D37', '各国共产党', 'Communist in The World', '1', '6', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7ef47b1c1030a8ee2610e0325a2b', null, '001004004007', null, 'D4', '工人、农民、青年、妇女运动与组织', 'Workers, Peasants , Youth, Women\'s Movement and Organization', '1', '7', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7f637b1c1030a8ee2610e0325a2b', null, '001004004008', null, 'D5', '世界政治', 'World Politics', '1', '8', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d7fce7b1c1030a8ee2610e0325a2b', null, '001004004009', null, 'D5/D7', '世界各国政治', 'Politics  of Each Country', '1', '9', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d80387b1c1030a8ee2610e0325a2b', null, '001004004010', null, 'D6', '中国政治', 'Chinese Politics', '1', '10', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d809b7b1c1030a8ee2610e0325a2b', null, '001004004011', null, 'D73/77', '各国政治', 'National Politics', '1', '11', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d81027b1c1030a8ee2610e0325a2b', null, '001004004012', null, 'D8', '外交、国际关系', 'Diplomacy, International Relations', '1', '12', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d816d7b1c1030a8ee2610e0325a2b', null, '001004004013', null, 'D9', '法律', 'Law', '1', '13', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('4f2d82197b1c1030a8ee2610e0325a2b', null, '001004004014', null, 'DF', '法律', 'Law', '1', '14', 'a468b4277b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('511d4f027b201030a8ee2610e0325a2b', null, '001021021001', null, 'V-6', '航空、航天参考工具书', 'Reference Books of Aviation, Aerospace', '1', '1', 'a468c8347b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('511d51147b201030a8ee2610e0325a2b', null, '001021021002', null, 'V1', '航空、航天技术的研究与探索', 'Research and Exploration of Aviation, Aerospace Technology ', '1', '2', 'a468c8347b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('511d521f7b201030a8ee2610e0325a2b', null, '001021021003', null, 'V2', '航空', 'Aviation,', '1', '3', 'a468c8347b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('511d53127b201030a8ee2610e0325a2b', null, '001021021004', null, 'V4', '航天（宇宙航行）', 'Aerospace ( Astronauts )', '1', '4', 'a468c8347b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('511d53f47b201030a8ee2610e0325a2b', null, '001021021005', null, 'V7', '航空、航天医学', 'Aviation, Aerospace', '1', '5', 'a468c8347b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d10df17b1f1030a8ee2610e0325a2b', null, '001017017001', null, 'R-0', '一般理论', 'General Theory ', '1', '1', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d10fd27b1f1030a8ee2610e0325a2b', null, '001017017002', null, 'R-1', '现状与发展', 'Current Situation and Development', '1', '2', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d1106a7b1f1030a8ee2610e0325a2b', null, '001017017003', null, 'R-2', '医学机构、团体、会议', 'Organizations, Groups , Conference of Medicine', '1', '3', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d110ee7b1f1030a8ee2610e0325a2b', null, '001017017004', null, 'R-3', '医学研究方法', ' Research Methods of Medicine', '1', '4', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d111697b1f1030a8ee2610e0325a2b', null, '001017017005', null, 'R-4', '医学教育与普及、普通医师考试', 'Disseminate and Study of Medicine,Examination  of General Practitioner ', '1', '5', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d111e47b1f1030a8ee2610e0325a2b', null, '001017017006', null, 'R-6', '医药、卫生工具书', 'Reference Books of Medicine and Health', '1', '6', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d112747b1f1030a8ee2610e0325a2b', null, '001017017007', null, 'R1', '预防医学、卫生学', 'Preventive Medicine , Health', '1', '7', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d112eb7b1f1030a8ee2610e0325a2b', null, '001017017008', null, 'R2', '中国医学', 'Chinese Medicine', '1', '8', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d1135e7b1f1030a8ee2610e0325a2b', null, '001017017009', null, 'R3', '基础医学', 'Basic Medical', '1', '9', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d113d17b1f1030a8ee2610e0325a2b', null, '001017017010', null, 'R4', '临床医学', 'Clinical Medicine', '1', '10', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d114407b1f1030a8ee2610e0325a2b', null, '001017017011', null, 'R5', '内科学', 'Internal Medicine', '1', '11', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d114b77b1f1030a8ee2610e0325a2b', null, '001017017012', null, 'R5/R8', '临床各科', 'Clinical Subjects', '1', '12', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d115337b1f1030a8ee2610e0325a2b', null, '001017017013', null, 'R6', '外科学', 'Surgery', '1', '13', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d115a67b1f1030a8ee2610e0325a2b', null, '001017017014', null, 'R71', '妇产科学', 'Obstetrics and Gynaecology', '1', '14', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d11b1b7b1f1030a8ee2610e0325a2b', null, '001017017015', null, 'R72', '儿科学', 'Pediatrics', '1', '15', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d11bd47b1f1030a8ee2610e0325a2b', null, '001017017016', null, 'R73', '肿瘤学', 'Oncology', '1', '16', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d11c747b1f1030a8ee2610e0325a2b', null, '001017017017', null, 'R74', '神经病学与精神病学', 'Neurology and Psychiatry', '1', '17', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d11d087b1f1030a8ee2610e0325a2b', null, '001017017018', null, 'R75', '皮肤病学与性病学', 'Dermatology and Venereology', '1', '18', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d11d9c7b1f1030a8ee2610e0325a2b', null, '001017017019', null, 'R76', '耳鼻咽喉科学', 'Ear, Nose & Throat', '1', '19', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d11f227b1f1030a8ee2610e0325a2b', null, '001017017020', null, 'R77', '眼科学', 'Ophthalmology', '1', '20', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d11fe37b1f1030a8ee2610e0325a2b', null, '001017017021', null, 'R78', '口腔科学', 'Oral Sciences', '1', '21', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d120677b1f1030a8ee2610e0325a2b', null, '001017017022', null, 'R79', '外国民族医学', 'Foreign National（Aboriginal/Native） Medical', '1', '22', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d120e67b1f1030a8ee2610e0325a2b', null, '001017017023', null, 'R8', '特种医学', 'Special Medical', '1', '23', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('58d134ca7b1f1030a8ee2610e0325a2b', null, '001017017024', null, 'R9', '药学', 'Pharmacy', '1', '24', 'a468bf127b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e481ff7b1e1030a8ee2610e0325a2b', null, '001013013001', null, 'N-6', '自然科学总论工具书', 'Reference Books of Natural Science', '1', '1', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e4839e7b1e1030a8ee2610e0325a2b', null, '001013013002', null, 'N0', '自然科学理论与方法论', 'Theory and Methodology of Natural Science', '1', '2', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e4843a7b1e1030a8ee2610e0325a2b', null, '001013013003', null, 'N1', '自然科学现状及发展', 'Current Situation and Development of Natural Science', '1', '3', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e486967b1e1030a8ee2610e0325a2b', null, '001013013004', null, 'N2', '自然科学机构、团体、会议', 'Organizations, Groups , Conference of Natural Science', '1', '4', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e4871d7b1e1030a8ee2610e0325a2b', null, '001013013005', null, 'N3', '自然科学研究方法', 'Natural Science Research Methods', '1', '5', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e4879d7b1e1030a8ee2610e0325a2b', null, '001013013006', null, 'N4', '自然科学教育与普及', 'Disseminate and Study of Natural Science', '1', '6', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e488187b1e1030a8ee2610e0325a2b', null, '001013013007', null, 'N5', '自然科学丛书、文集、连续性出版物', 'Books , Collected Works , Series of Natural Science', '1', '7', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e488937b1e1030a8ee2610e0325a2b', null, '001013013008', null, 'N6', '自然科学参考工具书', 'Reference Books of Natural Science', '1', '8', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e48aeb7b1e1030a8ee2610e0325a2b', null, '001013013009', null, 'N7', '自然科学文献检索工具', 'Reference Books of Natural Science Literature Searching ', '1', '9', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e48b6b7b1e1030a8ee2610e0325a2b', null, '001013013010', null, 'N8', '自然科学调查、考察', 'Investigation and Study of Natural Science ', '1', '10', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e48be27b1e1030a8ee2610e0325a2b', null, '001013013011', null, 'N91', '自然研究、自然历史', 'Nature Study , Nature History', '1', '11', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e48c597b1e1030a8ee2610e0325a2b', null, '001013013012', null, 'N93', '非线性科学', 'Nonlinear Science', '1', '12', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e48ccc7b1e1030a8ee2610e0325a2b', null, '001013013013', null, 'N94', '系统科学', 'Systems Science', '1', '13', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('59e48d377b1e1030a8ee2610e0325a2b', null, '001013013014', null, 'N99', '情报学、情报工作', 'Information Science, Intelligence Works', '1', '14', 'a468bc707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616212397b201030a8ee2610e0325a2b', null, '001022022001', null, 'X-0', '环境科学理论', 'Environmental Science Theory', '1', '1', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616213f47b201030a8ee2610e0325a2b', null, '001022022002', null, 'X-05', '环境科学与其他学科的关系', 'The Relationship of Environmental Scienceand Other Sciences', '1', '2', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616214a57b201030a8ee2610e0325a2b', null, '001022022003', null, 'X-1', '环境科学技术现状与发展', 'Current Situation and Development of Environmental Science', '1', '3', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('6162152d7b201030a8ee2610e0325a2b', null, '001022022004', null, 'X-4', '环境保护宣传教育及普及', 'Disseminate and Study of Environmental Protection', '1', '4', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616215b07b201030a8ee2610e0325a2b', null, '001022022005', null, 'X-6', '环境保护参考工具书', 'Reference Books of Environmental Protection', '1', '5', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616216307b201030a8ee2610e0325a2b', null, '001022022006', null, 'X1', '环境科学基础理论', 'Environmental Science Basic Theory', '1', '6', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616216ab7b201030a8ee2610e0325a2b', null, '001022022007', null, 'X2', '社会与环境', 'Social and Environment', '1', '7', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616217267b201030a8ee2610e0325a2b', null, '001022022008', null, 'X3', '环境保护管理', 'Environmental Protection Management', '1', '8', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616217997b201030a8ee2610e0325a2b', null, '001022022009', null, 'X4', '灾害及其防治', 'Disasters and Prevention', '1', '9', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('6162184e7b201030a8ee2610e0325a2b', null, '001022022010', null, 'X5', '环境污染及其防治', 'Environmental Pollution and Prevention', '1', '10', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616218ea7b201030a8ee2610e0325a2b', null, '001022022011', null, 'X7', '废物处理与综合利用', 'Processing and Comprehensive Utilization of Waste', '1', '11', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616219617b201030a8ee2610e0325a2b', null, '001022022012', null, 'X8', '环境质量评价与环境监测', 'Environmental Quality Assessment and Environmental Monitoring', '1', '12', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('616219d47b201030a8ee2610e0325a2b', null, '001022022013', null, 'X9', '安全科学', 'Safety Science', '1', '13', 'a468c8d07b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a27d477b1b1030a8ee2610e0325a2b', null, '001001001001', null, 'A1', '马克思、恩格斯著作', 'Works of Marx and Engels', '1', '1', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a27f347b1b1030a8ee2610e0325a2b', null, '001001001002', null, 'A1/A49', '(特殊分类规定)', 'Null', '1', '2', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a2800a7b1b1030a8ee2610e0325a2b', null, '001001001003', null, 'A2', '列宁著作', 'Works of Lenin', '1', '3', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a280c77b1b1030a8ee2610e0325a2b', null, '001001001004', null, 'A3', '斯大林著作', 'Works of Stalin', '1', '4', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a2817c7b1b1030a8ee2610e0325a2b', null, '001001001005', null, 'A4', '毛泽东著作', 'Works of Mao Tse-tung', '1', '5', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a2823d7b1b1030a8ee2610e0325a2b', null, '001001001005', null, 'A49', '邓小平著作', 'Works of Deng Xiaoping', '1', '6', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a282e97b1b1030a8ee2610e0325a2b', null, '001001001006', null, 'A5', '马克思、恩格斯、列宁、斯大林、毛泽东、邓小平著作汇编', 'Collected Works of Marx , Engels, Lenin,Stalin,Mao Tse-tung,Deng Xiaoping', '1', '7', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a283a27b1b1030a8ee2610e0325a2b', null, '001001001007', null, 'A7', '马克思、恩格斯、列宁、斯大林、毛泽东、邓小平生平和传记', 'Biography of Marx , Engels, Lenin,Stalin,Mao Tse-tung,Deng Xiaoping', '1', '8', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('66a284537b1b1030a8ee2610e0325a2b', null, '001001001008', null, 'A8', '马克思主义、列宁主义、毛泽东思想、邓小平理论的学习和研究', 'Study of Marxism-Leninism , Mao Tse-tung Thought , Deng Xiaoping Theory', '1', '9', 'a468aff37b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8339d2037b201030a8ee2610e0325a2b', null, '001023023001', null, 'Z1', '丛书', 'Book Series', '1', '1', 'a468c9707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8339d5397b201030a8ee2610e0325a2b', null, '001023023002', null, 'Z2', '百科全书、类书', 'Encyclopedias, Reference Books', '1', '2', 'a468c9707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8339d6447b201030a8ee2610e0325a2b', null, '001023023003', null, 'Z3', '辞典', 'Dictionary', '1', '3', 'a468c9707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8339d71a7b201030a8ee2610e0325a2b', null, '001023023004', null, 'Z4', '论文集、全集、选集、杂著', 'thesis Collections,Complete Works,Anthology,Essay', '1', '4', 'a468c9707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8339d8047b201030a8ee2610e0325a2b', null, '001023023005', null, 'Z5', '年鉴、年刊', 'Yearbook,Annual', '1', '5', 'a468c9707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8339d8d67b201030a8ee2610e0325a2b', null, '001023023006', null, 'Z6', '期刊、连续性出版物', 'Periodical,Serials', '1', '6', 'a468c9707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8339d9977b201030a8ee2610e0325a2b', null, '001023023007', null, 'Z8', '图书目录、文摘、索引', 'Library catalog,Abstract,Index', '1', '7', 'a468c9707b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8dded8637b1f1030a8ee2610e0325a2b', null, '001018018001', null, '02', 'S-1m农业科学技术现状与发展', 'Current Situation and Development of S-1m Agricultural Sciences Technology', '1', '1', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddeda1b7b1f1030a8ee2610e0325a2b', null, '001018018002', null, 'S-0', '一般性理论', 'General Theory', '1', '2', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedab37b1f1030a8ee2610e0325a2b', null, '001018018003', null, 'S-3', '农业科学研究、试验', 'Research and Experiment of Agricultural Sciences', '1', '3', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedb367b1f1030a8ee2610e0325a2b', null, '001018018004', null, 'S-6', '农业科学工具书', 'Reference Books of Agricultural Sciences', '1', '4', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedbc67b1f1030a8ee2610e0325a2b', null, '001018018005', null, 'S-9', '农业经济', 'Agricultural Economy', '1', '5', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedc467b1f1030a8ee2610e0325a2b', null, '001018018006', null, 'S1', '农业基础科学', 'Basic Agriculture Science', '1', '6', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedcc17b1f1030a8ee2610e0325a2b', null, '001018018007', null, 'S2', '农业工程', 'Agricultural Engineering', '1', '7', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedd347b1f1030a8ee2610e0325a2b', null, '001018018008', null, 'S3', '农学（农艺学）', 'Agriculture ( Agronomy )', '1', '8', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedda77b1f1030a8ee2610e0325a2b', null, '001018018009', null, 'S4', '植物保护', 'Plant Protection', '1', '9', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddede167b1f1030a8ee2610e0325a2b', null, '001018018010', null, 'S5', '农作物', 'Cultivation of Crops', '1', '10', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddede897b1f1030a8ee2610e0325a2b', null, '001018018011', null, 'S6', '园艺', 'Gardening', '1', '11', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedef87b1f1030a8ee2610e0325a2b', null, '001018018012', null, 'S7', '林业', 'Forestry', '1', '12', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedf677b1f1030a8ee2610e0325a2b', null, '001018018013', null, 'S8', '畜牧、动物医学、狩猎、蚕、蜂', 'Livestock, Animal Medicine , Hunting , Silkworm , Bee', '1', '13', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8ddedfe27b1f1030a8ee2610e0325a2b', null, '001018018014', null, 'S9', '水产、渔业', 'Aquaculture, Fishery', '1', '14', 'a468bfb27b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8f978def7b1d1030a8ee2610e0325a2b', null, '001009009001', null, 'I-6', '文学工具书', 'Reference Books of Literature', '1', '1', 'a468ba077b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8f9790647b1d1030a8ee2610e0325a2b', null, '001009009002', null, 'I0', '文学理论', 'Literary Theory', '1', '2', 'a468ba077b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8f97918c7b1d1030a8ee2610e0325a2b', null, '001009009003', null, 'I1', '世界文学', 'World Literature', '1', '3', 'a468ba077b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8f97928b7b1d1030a8ee2610e0325a2b', null, '001009009004', null, 'I2', '中国文学', 'Chinese Literature', '1', '4', 'a468ba077b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('8f9793607b1d1030a8ee2610e0325a2b', null, '001009009005', null, 'I3/I7', '各国文学', 'Literatures of Each Country', '1', '5', 'a468ba077b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02b8e87b1d1030a8ee2610e0325a2b', null, '001010010001', null, 'J-6', '艺术工具书', 'Reference Books of Art', '1', '1', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bac97b1d1030a8ee2610e0325a2b', null, '001010010002', null, 'J0', '艺术理论', 'Art Theory', '1', '2', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bbc47b1d1030a8ee2610e0325a2b', null, '001010010003', null, 'J1', '世界各国艺术概况', 'Overview of World Art', '1', '3', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bc8d7b1d1030a8ee2610e0325a2b', null, '001010010004', null, 'J2', '绘画', 'Drawing', '1', '4', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bd4a7b1d1030a8ee2610e0325a2b', null, '001010010005', null, 'J29', '书法、篆刻', 'Calligraphy, Seal Cutting', '1', '5', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bdfb7b1d1030a8ee2610e0325a2b', null, '001010010006', null, 'J3', '雕塑', 'Sculpturing Art', '1', '6', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bea87b1d1030a8ee2610e0325a2b', null, '001010010007', null, 'J4', '摄影艺术', 'Photographing Art', '1', '7', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bf587b1d1030a8ee2610e0325a2b', null, '001010010008', null, 'J5', '工艺美术', 'Industrial Art', '1', '8', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02bffd7b1d1030a8ee2610e0325a2b', null, '00101001009', null, 'J59', '建筑艺术', 'Architectural Art', '1', '9', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02e9e27b1d1030a8ee2610e0325a2b', null, '001010010010', null, 'J6', '音乐', 'Music', '1', '10', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02eb787b1d1030a8ee2610e0325a2b', null, '001010010011', null, 'J7', '舞蹈', 'Dancing', '1', '11', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02ec317b1d1030a8ee2610e0325a2b', null, '001010010012', null, 'J8', '戏剧艺术', 'Dramatic ', '1', '12', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('9a02ecda7b1d1030a8ee2610e0325a2b', null, '001010010013', null, 'J9', '电影、电视艺术', 'Movies, TV ', '1', '13', 'a468ba9b7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('a2be725a7b1e1030a8ee2610e0325a2b', null, '001014014001', null, 'O-6', '数理科学和化学工具书', 'Reference Books of Mathematical Science and Chemistry', '1', '1', 'a468bd107b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('a2be73f17b1e1030a8ee2610e0325a2b', null, '001014014002', null, 'O1', '数学', 'Mathematics', '1', '2', 'a468bd107b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('a2be748d7b1e1030a8ee2610e0325a2b', null, '001014014003', null, 'O3', '力学', 'Mechanics ', '1', '3', 'a468bd107b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('a2be75197b1e1030a8ee2610e0325a2b', null, '001014014004', null, 'O4', '物理学', 'Physics', '1', '4', 'a468bd107b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('a2be75a87b1e1030a8ee2610e0325a2b', null, '001014014005', null, 'O6', '化学', 'Chemistry', '1', '5', 'a468bd107b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('a2be763c7b1e1030a8ee2610e0325a2b', null, '001014014006', null, 'O7', '晶体学', 'Crystallography', '1', '6', 'a468bd107b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('a468aff37b1a1030a8ee2610e0325a2b', null, '001001', null, 'A', '马克思主义、列宁主义、毛泽东思想、邓小平理论', 'Marxism-Leninism , Mao Tse-tung Thought , Deng Xiaoping Theory', '1', '1', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468b22e7b1a1030a8ee2610e0325a2b', null, '001002', null, 'B', '哲学、宗教', 'Philosophy && Religion', '1', '2', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468b3397b1a1030a8ee2610e0325a2b', null, '001003', null, 'C', '社会科学总论', 'Pandect of Social Sciences ', '1', '3', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468b4277b1a1030a8ee2610e0325a2b', null, '001004', null, 'D', '政治、法律', 'Political  && Legal', '1', '4', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468b50d7b1a1030a8ee2610e0325a2b', null, '001005', null, 'E', '军事', 'military', '1', '5', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468b74d7b1a1030a8ee2610e0325a2b', null, '001006', null, 'F', '经济', 'economic', '1', '6', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468b85c7b1a1030a8ee2610e0325a2b', null, '001007', null, 'G', '文化、科学、教育、体育', 'Culture, Science , Education, Sports', '1', '7', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468b96b7b1a1030a8ee2610e0325a2b', null, '001008', null, 'H', '语言、文字', 'Language && Linguistics', '1', '8', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468ba077b1a1030a8ee2610e0325a2b', null, '001009', null, 'I', '文学', 'Literature', '1', '9', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468ba9b7b1a1030a8ee2610e0325a2b', null, '001010', null, 'J', '艺术', 'Art', '1', '10', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468bb377b1a1030a8ee2610e0325a2b', null, '001011', null, 'K', '历史、地理', 'History && Geography', '1', '11', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468bbd87b1a1030a8ee2610e0325a2b', null, '001012', null, 'L', '暂无分类', 'Null', '1', '12', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468bc707b1a1030a8ee2610e0325a2b', null, '001013', null, 'N', '自然科学总论', 'Pandect of Natural Science', '1', '13', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468bd107b1a1030a8ee2610e0325a2b', null, '001014', null, 'O', '数理科学和化学', 'Mathematical Sciences and Chemical', '1', '14', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468bdc17b1a1030a8ee2610e0325a2b', null, '001015', null, 'P', '天文学、地球科学', 'Astronomy && Earth Sciences', '1', '15', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468be697b1a1030a8ee2610e0325a2b', null, '001016', null, 'Q', '生物科学', 'Biological Sciences', '1', '16', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468bf127b1a1030a8ee2610e0325a2b', null, '001017', null, 'R', '医药、卫生', 'Medicine && Health', '1', '17', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468bfb27b1a1030a8ee2610e0325a2b', null, '001018', null, 'S', '农业科学', 'Agricultural Sciences', '1', '18', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468c0527b1a1030a8ee2610e0325a2b', null, '001019', null, 'T', '工业技术', 'Industrial Technology', '1', '19', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468c76a7b1a1030a8ee2610e0325a2b', null, '001020', null, 'U', '交通运输', 'Transportation', '1', '20', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468c8347b1a1030a8ee2610e0325a2b', null, '001021', null, 'V', '航空、航天', 'Aviation, Aerospace', '1', '21', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468c8d07b1a1030a8ee2610e0325a2b', null, '001022', null, 'X', '环境科学、安全科学', 'Environmental Science, Safety Science', '1', '22', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('a468c9707b1a1030a8ee2610e0325a2b', null, '001023', null, 'Z', '综合性图书', 'Comprehensive Articles', '1', '23', '2c9080863ab97aa0013ab985215c0000');
INSERT INTO `bc_b_subject` VALUES ('ac4c82ec7b1e1030a8ee2610e0325a2b', null, '001015015001', null, 'P-6', '天文学、地球科学工具书', 'Reference Books of Astronomy , Earth Science', '1', '1', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c848f7b1e1030a8ee2610e0325a2b', null, '001015015002', null, 'P1', '天文学', 'Astronomy', '1', '2', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c85237b1e1030a8ee2610e0325a2b', null, '001015015003', null, 'P2', '测绘学', 'Surveying and Mapping', '1', '3', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c85a37b1e1030a8ee2610e0325a2b', null, '001015015004', null, 'P3', '地球物理学', 'Geophysics', '1', '4', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c861e7b1e1030a8ee2610e0325a2b', null, '001015015005', null, 'P4', '大气科学（气象学）', 'Atmospheric science (Meteorology )', '1', '5', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c86997b1e1030a8ee2610e0325a2b', null, '001015015006', null, 'P5', '地质学', 'Geology', '1', '6', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c87087b1e1030a8ee2610e0325a2b', null, '001015015007', null, 'P7', '海洋学', 'Oceanography', '1', '7', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c877b7b1e1030a8ee2610e0325a2b', null, '001015015008', null, 'P7-6', '海洋学工具书', 'Reference Books of Oceanography', '1', '8', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('ac4c87ea7b1e1030a8ee2610e0325a2b', null, '001015015009', null, 'P9', '自然地理学', 'Natural Geography', '1', '9', 'a468bdc17b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b813fc257b1c1030a8ee2610e0325a2b', null, '001005005001', null, 'E-6', '军事工具书', 'Reference Books of Military ', '1', '1', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b813fe1b7b1c1030a8ee2610e0325a2b', null, '001005005002', null, 'E0', '军事理论', 'Military Theory', '1', '2', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b813fee47b1c1030a8ee2610e0325a2b', null, '001005005003', null, 'E1', '世界军事', 'The World\'s Military', '1', '3', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b813ffa17b1c1030a8ee2610e0325a2b', null, '001005005004', null, 'E2', '中国军事', 'Chinese Military', '1', '4', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b814005a7b1c1030a8ee2610e0325a2b', null, '001005005005', null, 'E3/E7', '各国军事', 'Military of Each Country', '1', '5', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b814010f7b1c1030a8ee2610e0325a2b', null, '001005005006', null, 'E8', '战略学、战役学、战术学', 'Study of Strategy,Battle,Tactic', '1', '6', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b81401bf7b1c1030a8ee2610e0325a2b', null, '001005005007', null, 'E9', '军事技术', 'Military Technology', '1', '7', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('b81402707b1c1030a8ee2610e0325a2b', null, '001005005008', null, 'E99', '军事地形学、军事地理学', 'Military Topography , Military Geography', '1', '8', 'a468b50d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2eda8647b1c1030a8ee2610e0325a2b', null, '001006006001', null, 'F-6', '经济工具书', 'Reference Books of Economics', '1', '1', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edc5b07b1c1030a8ee2610e0325a2b', null, '001006006002', null, 'F0', '经济学', 'Economics', '1', '2', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edc71e7b1c1030a8ee2610e0325a2b', null, '001006006003', null, 'F1', '世界各国经济概况、经济史、经济地理', 'The World Economic Profiles , Economic History , Economic Geography', '1', '3', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edc8007b1c1030a8ee2610e0325a2b', null, '001006006004', null, 'F2', '经济计划与管理', 'Economic Planning and Management', '1', '4', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edc8c97b1c1030a8ee2610e0325a2b', null, '001006006005', null, 'F3', '农业经济', 'Agricultural Economy', '1', '5', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edc9927b1c1030a8ee2610e0325a2b', null, '001006006006', null, 'F4', '工业经济', 'Industrial Economy', '1', '6', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edca577b1c1030a8ee2610e0325a2b', null, '001006006007', null, 'F49', '信息产业经济(总论)', 'Information Industry economy ( Summary )', '1', '7', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edd28b7b1c1030a8ee2610e0325a2b', null, '001006006008', null, 'F5', '交通运输经济', 'Transportation Economy', '1', '8', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edd3767b1c1030a8ee2610e0325a2b', null, '001006006009', null, 'F59', '旅游经济', 'Tourism Economy', '1', '9', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edd4437b1c1030a8ee2610e0325a2b', null, '001006006010', null, 'F6', '邮电经济', 'Posts and Telecommunications Economy', '1', '10', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edd5197b1c1030a8ee2610e0325a2b', null, '001006006011', null, 'F7', '贸易经济', 'Trade Economy', '1', '11', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('c2edd5e67b1c1030a8ee2610e0325a2b', null, '001006006012', null, 'F8', '财政、金融', 'Finances', '1', '12', 'a468b74d7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc54846b7b1b1030a8ee2610e0325a2b', null, '001002002001', null, 'B-4', '哲学教育与普及', 'Philosophical Education and Its Dissemination ', '1', '1', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc54861e7b1b1030a8ee2610e0325a2b', null, '001002002002', null, 'B-6', '哲学、宗教工具书', 'Reference Books of Philosophy and Religion ', '1', '2', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5486aa7b1b1030a8ee2610e0325a2b', null, '001002002003', null, 'B0', '哲学理论', 'Philosophical Theory', '1', '3', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5487217b1b1030a8ee2610e0325a2b', null, '001002002004', null, 'B1', '世界哲学', 'World Philosophy', '1', '4', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc54878c7b1b1030a8ee2610e0325a2b', null, '001002002005', null, 'B2', '中国哲学', 'Chinese Philosophy', '1', '5', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5487fb7b1b1030a8ee2610e0325a2b', null, '001002002006', null, 'B3', '亚洲哲学', 'Asian philosophy', '1', '6', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5488627b1b1030a8ee2610e0325a2b', null, '001002002007', null, 'B4', '非洲哲学', 'African philosophy', '1', '7', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5488c87b1b1030a8ee2610e0325a2b', null, '001002002008', null, 'B5', '欧洲哲学', 'European philosophy', '1', '8', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc54892f7b1b1030a8ee2610e0325a2b', null, '001002002009', null, 'B6', '大洋洲哲学', 'Oceania Philosophy', '1', '9', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5489967b1b1030a8ee2610e0325a2b', null, '001002002010', null, 'B7', '美洲哲学', 'Inter-American philosophy', '1', '10', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5489fd7b1b1030a8ee2610e0325a2b', null, '001002002011', null, 'B80', '思维科学', 'Noetic Sciences', '1', '11', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc54930e7b1b1030a8ee2610e0325a2b', null, '001002002012', null, 'B81', '逻辑学(论理学)', 'Logic(Theory Sciences)', '1', '12', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5493e47b1b1030a8ee2610e0325a2b', null, '001002002013', null, 'B82', '伦理学(道德哲学)', 'Ethics ( Moral Philosophy )', '1', '13', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5494637b1b1030a8ee2610e0325a2b', null, '001002002014', null, 'B83', '美学', 'Aesthetics', '1', '14', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5494d27b1b1030a8ee2610e0325a2b', null, '001002002015', null, 'B84', '心理学', 'Psychology', '1', '15', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('cc5495397b1b1030a8ee2610e0325a2b', null, '001002002016', null, 'B9', '宗教', 'Religion', '1', '16', 'a468b22e7b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fb3017b1f1030a8ee2610e0325a2b', null, '001019019001', null, 'T-0', '工业技术理论', 'Theory of Industrial Technology', '1', '1', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fb54d7b1f1030a8ee2610e0325a2b', null, '001019019002', null, 'T-1', '工业技术现状与发展', 'Technology Status and Development', '1', '2', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fb64c7b1f1030a8ee2610e0325a2b', null, '001019019003', null, 'T-2', '机构、团体、会议', 'Organizations, Groups , Conference', '1', '3', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fb7217b1f1030a8ee2610e0325a2b', null, '001019019004', null, 'T-6', '参考工具书', 'Reference Books', '1', '4', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fb7f37b1f1030a8ee2610e0325a2b', null, '001019019005', null, 'T-9', '工业经济', 'Industrial Economy', '1', '5', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fb8c97b1f1030a8ee2610e0325a2b', null, '001019019006', null, 'TB', '一般工业技术', 'General Industrial Technology', '1', '6', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fb98e7b1f1030a8ee2610e0325a2b', null, '001019019007', null, 'TD', '矿业工程', 'Mining Engineering', '1', '7', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fba537b1f1030a8ee2610e0325a2b', null, '001019019008', null, 'TE', '石油、天然气工业', 'Oil and Gas Industry', '1', '8', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fbb207b1f1030a8ee2610e0325a2b', null, '001019019009', null, 'TF', '冶金工业', 'Metallurgical Industry', '1', '9', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fbbee7b1f1030a8ee2610e0325a2b', null, '001019019010', null, 'TG', '金属学与金属工艺', 'Metallurgy and Metal Craft', '1', '10', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fbcbb7b1f1030a8ee2610e0325a2b', null, '001019019011', null, 'TH', '机械、仪表工业', 'Machinery and Instrument Industry', '1', '11', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fbda27b1f1030a8ee2610e0325a2b', null, '001019019012', null, 'TJ', '武器工业', 'Weapon industry', '1', '12', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fbe737b1f1030a8ee2610e0325a2b', null, '001019019013', null, 'TK', '能源与动力工程', 'Energy and Power Engineering', '1', '13', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fbf387b1f1030a8ee2610e0325a2b', null, '001019019014', null, 'TL', '原子能技术', 'Nuclear  Technology', '1', '14', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fbffe7b1f1030a8ee2610e0325a2b', null, '001019019015', null, 'TM', '电工技术', 'Electrotechnical', '1', '15', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fc0c37b1f1030a8ee2610e0325a2b', null, '001019019016', null, 'TN', '无线电电子学、电信技术', 'Radio Electronics, Telecommunications Technology', '1', '16', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fc18c7b1f1030a8ee2610e0325a2b', null, '001019019017', null, 'TP', '自动化技术、计算机技术', 'Automation Technology , Computer Technology', '1', '17', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fc2567b1f1030a8ee2610e0325a2b', null, '001019019018', null, 'TQ', '化学工业', 'Chemical Industry', '1', '18', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fc3137b1f1030a8ee2610e0325a2b', null, '001019019019', null, 'TS', '轻工业、手工业', 'Light industry ,Handicrafts', '1', '19', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fe4077b1f1030a8ee2610e0325a2b', null, '001019019020', null, 'TU', '建筑科学', 'Architectural Science  ', '1', '20', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f14fe5c37b1f1030a8ee2610e0325a2b', null, '001019019021', null, 'TV', '水利工程', 'Hydraulic Engineering', '1', '21', 'a468c0527b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b689a7b1d1030a8ee2610e0325a2b', null, '001011011001', null, 'K-6', '历史、地理工具书', 'Reference Books of History, Geography', '1', '1', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b6b727b1d1030a8ee2610e0325a2b', null, '001011011002', null, 'K0', '史学理论', 'Historical Theory', '1', '2', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b6ccf7b1d1030a8ee2610e0325a2b', null, '001011011003', null, 'K1', '世界史', 'World History', '1', '3', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b6e187b1d1030a8ee2610e0325a2b', null, '001011011004', null, 'K2', '中国史', 'Chinese History', '1', '4', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b6f647b1d1030a8ee2610e0325a2b', null, '001011011005', null, 'K3', '亚洲史', 'Asian History', '1', '5', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b70a97b1d1030a8ee2610e0325a2b', null, '001011011006', null, 'K3/K7', '世界各国和地区历史', 'Countries and Regional History', '1', '6', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b71d57b1d1030a8ee2610e0325a2b', null, '001011011007', null, 'K4', '非洲史', 'African History', '1', '7', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b72ec7b1d1030a8ee2610e0325a2b', null, '001011011008', null, 'K5', '欧洲史', 'European History', '1', '8', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b74107b1d1030a8ee2610e0325a2b', null, '001011011009', null, 'K6', '大洋洲史', 'Oceania History', '1', '9', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b752c7b1d1030a8ee2610e0325a2b', null, '001011011010', null, 'K7', '美洲史', 'Americas History ', '1', '10', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b764f7b1d1030a8ee2610e0325a2b', null, '001011011011', null, 'K81', '传记', 'Biography', '1', '11', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b775f7b1d1030a8ee2610e0325a2b', null, '001011011012', null, 'K85', '文物考古', 'Archaeology', '1', '12', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b788f7b1d1030a8ee2610e0325a2b', null, '001011011013', null, 'K89', '风俗习惯', 'Custom', '1', '13', 'a468bb377b1a1030a8ee2610e0325a2b');
INSERT INTO `bc_b_subject` VALUES ('f32b79aa7b1d1030a8ee2610e0325a2b', null, '001011011014', null, 'K9', '地理', 'Geography', '1', '14', 'a468bb377b1a1030a8ee2610e0325a2b');
