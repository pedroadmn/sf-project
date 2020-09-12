package com.example.safra.interfaces;

import androidx.fragment.app.Fragment;

public interface FragmentChangeListener
{
    public void replaceFragment(Fragment fragment, Boolean backStackable);
}