package com.amrabdelhamiddiab.myprefrencemanager

interface IPreferenceHelper {
    fun setUserLoggedIn(loggedIn: Boolean)
    fun getUserLoggedIn(): Boolean
    fun clearPrefs()
    fun saveService(serviceString: String)
    fun loadService(): String
}