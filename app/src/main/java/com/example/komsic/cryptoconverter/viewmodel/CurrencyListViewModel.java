package com.example.komsic.cryptoconverter.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.komsic.cryptoconverter.data.CurrencyRepository;
import com.example.komsic.cryptoconverter.data.db.CurrencyCard;
import com.example.komsic.cryptoconverter.data.db.CurrencyCardSubset;

import java.util.List;

public class CurrencyListViewModel extends ViewModel {
    private static final String TAG = "CurrencyListViewModel";

    private CurrencyRepository mRepository;
    private LiveData<List<CurrencyCard>> mSelectedCurrencies;
    private LiveData<List<CurrencyCardSubset>> mUnselectedCurrencies;

    public CurrencyListViewModel(CurrencyRepository repository) {
        mRepository = repository;
        mSelectedCurrencies = mRepository.getSelectedCard();
        mUnselectedCurrencies = mRepository.getUnselectedCard();
    }

    public LiveData<List<CurrencyCard>> getSelectedCurrencies() {
        return mSelectedCurrencies;
    }

    public LiveData<List<CurrencyCardSubset>> getUnselectedCurrencies() {
        return mUnselectedCurrencies;
    }

    public MutableLiveData<Boolean> getRemoteDataFetchingStatus() {
        return CurrencyRepository.getRemoteDataFetchingStatus();
    }

    public void updateRates() {
        mRepository.updateRates();
    }

    public void updateSelectedStatus(String currencyType, boolean selectedStatus) {
        mRepository.updateSelectedStatus(currencyType, selectedStatus);
    }
}
