# Online Shoppers Intention Prediction

This project predicts whether an online shopper will make a purchase based on their browsing session data. It applies supervised machine learning, handles class imbalance, and evaluates the model with appropriate classification metrics.

---

# Notebook: `Anurag_pawar_online_shoppers_intention.ipynb`

# Project Workflow:

1. **Importing Data**
2. **Data Cleaning & Preprocessing**
3. **Feature Engineering**
4. **Splitting Dataset**
5. **Balancing Data using SMOTE**
6. **Training Models (GradientBoosting, RandomForest)**
7. **Hyperparameter Tuning (RandomizedSearchCV)**
8. **Threshold Tuning**
9. **Model Evaluation**
10. **Visualization (ROC, PR Curve, Confusion Matrix)**

---

## ML Techniques Used

- GradientBoostingClassifier
- SMOTE (oversampling for imbalance)
- RandomizedSearchCV
- Classification Metrics (Precision, Recall, F1, AUC)
- Threshold tuning

---

## Dependencies

Install required packages using:

```bash
pip install numpy pandas matplotlib seaborn scikit-learn imbalanced-learn
