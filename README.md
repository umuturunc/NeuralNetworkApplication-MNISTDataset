# NeuralNetworkApplication-MNISTDataset\
<h3>EL yazısı ile yazılmış rakamları tahminleme</h3>
MNIST veri setinden alınmış, 10 farklı rakamın el yazısıyla yazılmış .png formatında resimler bulunmaktadır. Eğitim(train) ve test verileri iki ayrı dizinde (mnist-train ve mnist-test adlı dizinler) olup, bunların her birisinin altında 10 rakama ait dizinler bulunmaktadır. Her bir rakam için 200 adet eğitim verisi ve 100 adet test verisi bulunmaktadır.</br>
<hr style="border:2px solid gray"> </hr>
learningRate = 0.01f <br />
maxEpoch = 100 <br />
hiddenLayerCount = 1\
hiddenNodeCount = 30 <br />
trainSize = 2000 <br />
testSize = 1000 <br />
outputNodeCount = 10(toplamda 10 adet rakam var)<br />

Program Çıktısı:
mnist-train -> 0. sınıftaki veriler okundu\
mnist-train -> 1. sınıftaki veriler okundu\
mnist-train -> 2. sınıftaki veriler okundu\
mnist-train -> 3. sınıftaki veriler okundu\
mnist-train -> 4. sınıftaki veriler okundu\
mnist-train -> 5. sınıftaki veriler okundu\
mnist-train -> 6. sınıftaki veriler okundu\
mnist-train -> 7. sınıftaki veriler okundu\
mnist-train -> 8. sınıftaki veriler okundu\
mnist-train -> 9. sınıftaki veriler okundu\
Toplamda 2000 adet veri okundu\
mnist-test -> 0. sınıftaki veriler okundu\
mnist-test -> 1. sınıftaki veriler okundu\
mnist-test -> 2. sınıftaki veriler okundu\
mnist-test -> 3. sınıftaki veriler okundu\
mnist-test -> 4. sınıftaki veriler okundu\
mnist-test -> 5. sınıftaki veriler okundu\
mnist-test -> 6. sınıftaki veriler okundu\
mnist-test -> 7. sınıftaki veriler okundu\
mnist-test -> 8. sınıftaki veriler okundu\
mnist-test -> 9. sınıftaki veriler okundu\
Toplamda 1000 adet veri okundu\
0. epoch Train Genel Accuracy: 0.1
1. epoch Train Genel Accuracy: 0.1
2. epoch Train Genel Accuracy: 0.1
3. epoch Train Genel Accuracy: 0.1005
4. epoch Train Genel Accuracy: 0.1215
5. epoch Train Genel Accuracy: 0.163
6. epoch Train Genel Accuracy: 0.198
7. epoch Train Genel Accuracy: 0.23
8. epoch Train Genel Accuracy: 0.262
9. epoch Train Genel Accuracy: 0.289
10. epoch Train Genel Accuracy: 0.323
11. epoch Train Genel Accuracy: 0.3475
12. epoch Train Genel Accuracy: 0.365
13. epoch Train Genel Accuracy: 0.38
14. epoch Train Genel Accuracy: 0.391
15. epoch Train Genel Accuracy: 0.4005
16. epoch Train Genel Accuracy: 0.4135
17. epoch Train Genel Accuracy: 0.423
18. epoch Train Genel Accuracy: 0.4355
19. epoch Train Genel Accuracy: 0.444
20. epoch Train Genel Accuracy: 0.448
21. epoch Train Genel Accuracy: 0.4585
22. epoch Train Genel Accuracy: 0.4665
23. epoch Train Genel Accuracy: 0.4735
24. epoch Train Genel Accuracy: 0.48
25. epoch Train Genel Accuracy: 0.4845
26. epoch Train Genel Accuracy: 0.4905
27. epoch Train Genel Accuracy: 0.497
28. epoch Train Genel Accuracy: 0.501
29. epoch Train Genel Accuracy: 0.5095
30. epoch Train Genel Accuracy: 0.518
31. epoch Train Genel Accuracy: 0.5225
32. epoch Train Genel Accuracy: 0.5265
33. epoch Train Genel Accuracy: 0.5295
34. epoch Train Genel Accuracy: 0.5405
35. epoch Train Genel Accuracy: 0.544
36. epoch Train Genel Accuracy: 0.5505
37. epoch Train Genel Accuracy: 0.5545
38. epoch Train Genel Accuracy: 0.5585
39. epoch Train Genel Accuracy: 0.565
40. epoch Train Genel Accuracy: 0.569
41. epoch Train Genel Accuracy: 0.574
42. epoch Train Genel Accuracy: 0.5795
43. epoch Train Genel Accuracy: 0.583
44. epoch Train Genel Accuracy: 0.59
45. epoch Train Genel Accuracy: 0.593
46. epoch Train Genel Accuracy: 0.596
47. epoch Train Genel Accuracy: 0.5995
48. epoch Train Genel Accuracy: 0.607
49. epoch Train Genel Accuracy: 0.6125
50. epoch Train Genel Accuracy: 0.618
51. epoch Train Genel Accuracy: 0.6205
52. epoch Train Genel Accuracy: 0.6235
53. epoch Train Genel Accuracy: 0.6305
54. epoch Train Genel Accuracy: 0.637
55. epoch Train Genel Accuracy: 0.6405
56. epoch Train Genel Accuracy: 0.643
57. epoch Train Genel Accuracy: 0.6465
58. epoch Train Genel Accuracy: 0.65
59. epoch Train Genel Accuracy: 0.6525
60. epoch Train Genel Accuracy: 0.6565
61. epoch Train Genel Accuracy: 0.661
62. epoch Train Genel Accuracy: 0.665
63. epoch Train Genel Accuracy: 0.666
64. epoch Train Genel Accuracy: 0.6715
65. epoch Train Genel Accuracy: 0.6755
66. epoch Train Genel Accuracy: 0.679
67. epoch Train Genel Accuracy: 0.6835
68. epoch Train Genel Accuracy: 0.688
69. epoch Train Genel Accuracy: 0.6915
70. epoch Train Genel Accuracy: 0.695
71. epoch Train Genel Accuracy: 0.698
72. epoch Train Genel Accuracy: 0.7015
73. epoch Train Genel Accuracy: 0.705
74. epoch Train Genel Accuracy: 0.7065
75. epoch Train Genel Accuracy: 0.7085
76. epoch Train Genel Accuracy: 0.711
77. epoch Train Genel Accuracy: 0.716
78. epoch Train Genel Accuracy: 0.72
79. epoch Train Genel Accuracy: 0.723
80. epoch Train Genel Accuracy: 0.7265
81. epoch Train Genel Accuracy: 0.729
82. epoch Train Genel Accuracy: 0.7325
83. epoch Train Genel Accuracy: 0.736
84. epoch Train Genel Accuracy: 0.7385
85. epoch Train Genel Accuracy: 0.7405
86. epoch Train Genel Accuracy: 0.741
87. epoch Train Genel Accuracy: 0.7435
88. epoch Train Genel Accuracy: 0.7465
89. epoch Train Genel Accuracy: 0.7485
90. epoch Train Genel Accuracy: 0.7525
91. epoch Train Genel Accuracy: 0.755
92. epoch Train Genel Accuracy: 0.756
93. epoch Train Genel Accuracy: 0.7595
94. epoch Train Genel Accuracy: 0.7605
95. epoch Train Genel Accuracy: 0.764
96. epoch Train Genel Accuracy: 0.767
97. epoch Train Genel Accuracy: 0.7715
98. epoch Train Genel Accuracy: 0.7745
99. epoch Train Genel Accuracy: 0.778
------------------------------------
0. sınıf için Train Accuracy: 0.975
1. sınıf için Train Accuracy: 0.965
2. sınıf için Train Accuracy: 0.655
3. sınıf için Train Accuracy: 0.335
4. sınıf için Train Accuracy: 0.715
5. sınıf için Train Accuracy: 0.765
6. sınıf için Train Accuracy: 0.99
7. sınıf için Train Accuracy: 0.49
8. sınıf için Train Accuracy: 0.895
9. sınıf için Train Accuracy: 0.995
------------------------------------
0. sınıf için Test Accuracy: 0.88
1. sınıf için Test Accuracy: 0.89
2. sınıf için Test Accuracy: 0.48
3. sınıf için Test Accuracy: 0.25
4. sınıf için Test Accuracy: 0.67
5. sınıf için Test Accuracy: 0.68
6. sınıf için Test Accuracy: 0.89
7. sınıf için Test Accuracy: 0.34
8. sınıf için Test Accuracy: 0.79
9. sınıf için Test Accuracy: 0.92
