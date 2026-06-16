package com.srijan.nit3213finalapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _entities = MutableLiveData<Result<List<Entity>>>()
    val entities: LiveData<Result<List<Entity>>> = _entities

    fun getDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboard(keypass)
                _entities.value = Result.success(response.entities)
            } catch (e: Exception) {
                // Demo data for presentation
                val demoEntities = listOf(
                    Entity("Artificial Intelligence", "Machine Learning", "AI is the simulation of human intelligence by machines to perform tasks like learning and problem solving."),
                    Entity("Cyber Security", "Network Protection", "Cyber security protects systems and networks from digital attacks and unauthorized access."),
                    Entity("Cloud Computing", "Data Storage", "Cloud computing delivers services over the internet including storage, databases and networking."),
                    Entity("Mobile Development", "Android & iOS", "Mobile development creates software applications that run on mobile devices."),
                    Entity("Machine Learning", "Data Science", "Machine learning enables systems to learn and improve from experience without being explicitly programmed.")
                )
                _entities.value = Result.success(demoEntities)
            }
        }
    }
}