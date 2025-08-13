---

## Ola Complaint Classifier

### Project Overview

This project is a **text classification system** designed to categorize customer complaints made to Ola.
It combines **zero-shot classification** for initial labeling and a **deep learning model** with **pre-trained word embeddings (GloVe)** for final classification.
The main goal is to automatically assign complaints to the most relevant category with high accuracy.

---

### Project Workflow

1. **Data Cleaning and Preprocessing**

   * Removal of punctuations.
   * Removal of stopwords using **NLTK stopword list**.
   * Stemming using **PorterStemmer** to normalize word forms.

2. **Initial Classification (Zero-Shot)**

   * Used Hugging Face's `facebook/bart-large-mnli` model to classify mislabelled data without needing training labels.
   * Generated a `predicted_label` column with the most probable category and confidence score.

3. **Tokenization & Sequence Preparation**

   * Tokenized complaint text using **Keras Tokenizer**.
   * Converted text to sequences and padded them to a fixed length (`max_len = 100`).

4. **Word Embeddings**

   * Loaded pre-trained **GloVe 100d** vectors.
   * Created an embedding matrix mapping vocabulary words to their respective GloVe vectors.

5. **Modeling**

   * Built a **Keras Sequential model** with:

     * Pre-trained Embedding layer (non-trainable)
     * GlobalAveragePooling1D
     * Dense layer with ReLU activation
     * Output layer with Softmax for multi-class classification
   * Trained on 80% of the dataset with stratified split.

6. **Prediction Function**

   * Created a `complaint(text)` function to predict the category of any given complaint.

---

### ML / NLP Techniques Used

* **Text Preprocessing**: Stopword removal, punctuation removal, stemming.
* **Zero-Shot Classification**: Hugging Face Transformers pipeline.
* **Tokenization & Padding**: Keras Tokenizer + `pad_sequences`.
* **Word Embeddings**: GloVe pre-trained 100d vectors.
* **Neural Network**: Sequential Keras model with Embedding + Dense layers.

---

### Dependencies

```bash
pip install pandas numpy nltk transformers tqdm scikit-learn tensorflow
```

```python
import nltk
nltk.download('stopwords')
```

---

### How to Run

1. Clone the repository or download the notebook.
2. Download `glove.6B.100d.txt` from [GloVe website](https://nlp.stanford.edu/projects/glove/) and place it in the working directory.
3. Run the preprocessing code to clean the complaint text.
4. Run the zero-shot classification step to create `predicted_label` for each complaint.
5. Train the model.
6. Use the `complaint()` function to classify new text inputs.

---

### Example Output

```python
complaint(["The driver was rude and overcharged me"])
```

Output:

```
Predicted Category : Driver Behaviour
```

---

