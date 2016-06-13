# Stanford Pos Tagger Server

## Introduction

Stanford POS tagger是用JAVA寫成的part-of-speech tagger，能將斷詞後的文字標註詞性，支援阿拉伯文、簡體中文、英文、法文、德文、西班牙文。

Stanford POS tagger server的用途是將JAVA程式包裝成SOAP service，以方便其他語言呼叫，`client.py`是用Python寫的範例程式。

Stadford POS tagger的演算法論文可以參考: [Kristina Toutanova and Christopher D. Manning. 2000. Enriching the Knowledge Sources Used in a Maximum Entropy Part-of-Speech Tagger](http://nlp.stanford.edu/~manning/papers/emnlp2000.pdf)、[Kristina Toutanova, Dan Klein, Christopher Manning, and Yoram Singer. 2003. Feature-Rich Part-of-Speech Tagging with a Cyclic Dependency Network](http://nlp.stanford.edu/~manning/papers/tagging.pdf)。


## Installation

1. 首先到[Stanford POS tagger](http://nlp.stanford.edu/software/tagger.shtml)下載[full Stanford Tagger version 3.6.0](http://nlp.stanford.edu/software/stanford-postagger-full-2015-12-09.zip)。
2. 將壓縮檔解壓後，應該會有一個獨立的`stanford-postagger-full-2015-12-09`目錄，將這個repository中的所有檔案都複製到該目錄下。
3. 執行`install.sh`，會執行以下任務
    * 解壓縮`stanford-postagger.jar`
    * 解壓縮`slf4j-api.jar`
    * 解壓縮`slf4j-simple.jar`
    * 解壓縮後，目錄下應該會多出`edu`, `org`, `META-INF`等目錄
4. 確定你有安裝Java SDK 8，並執行`make.sh`，裡面作的事情很簡單
    * 建立目錄 `service/endp`
    * compile `PosService.java`並放在`service/impl`
    * compile `PosServiceImpl.java`並放在`service/impl`
    * compile `PosServicePublisher.java`並放在`service/endp`
5. 確定你有安裝Java SDK 8，然後執行`run.sh`，這樣service就啟動了。當第一次呼叫service時，會載入資料，大約需0.6秒。


## Customization

1. Sementer使用的model定義在`PosServiceImpl.java`第33行，預設值為`data/ctb.gz`代表中文
2. 分行符號定義在`PosServiceImpl.java`第33行，預設值為`\\$\\$\\$`
3. Port number定義在`PosServicePublisher.java`第10行，預設值為`http://localhost:9998/pos`


## Usage

1. 在Python中安裝`suds`套件
    * 在Python2可以用`pip install suds`
    * 在Python3可以用`pip3 install suds-py3`
2. 建立一個SOAP Client，就可以使用Stanford POS tagger了
    * `from suds.client import Client`
    * `posClient = Client('http://localhost:9998/pos?wsdl')`
    * `posClient.service.getPostagResult(segmented_text)`
3. 注意事項
    * 因為訓練資料是簡體，所以要文字轉為簡體再作pos tagging
    * Stanford POS tagger需要輸入已斷詞的字串，例如`"对于 开发者 而言 ， 可能 实际 作用 并不 明显 。"`
    * POS tagger的輸入以句子為單位，當輸入是一篇文章時，需要在句子分界處加上`$$$`符號，例如`"通过 它 帮助 开发者 更 有效 地 推广 自己 的 App 。$$$  的确 ， 苹果 推出 竞价 排名 机制"`
    * POS tagger會自動將半形英文及數字轉換成全形
