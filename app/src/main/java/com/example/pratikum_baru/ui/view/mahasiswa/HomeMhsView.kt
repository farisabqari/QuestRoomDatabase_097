package com.example.pratikum_baru.ui.view.mahasiswa

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambdaInstance
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pratikum_baru.Data.Entity.Mahasiswa
import com.example.pratikum_baru.ui.custumewidget.CstTopAppBar
import com.example.pratikum_baru.ui.viewmodel.HomeMhsViewModel
import com.example.pratikum_baru.ui.viewmodel.HomeUiState
import com.example.pratikum_baru.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch


@Composable
fun HomeMhsView(
    viewModel: HomeMhsViewModel = viewModel(factory = PenyediaViewModel.Factory),
    onAddMhs: () -> Unit = { },
    onDetailClick: (String) -> Unit = { },
    modifier: Modifier = Modifier
) {
    Scaffold (
        topBar = {
            CstTopAppBar(
                judul = "Daftar Mahasiswa",
                showBackButton = false,
                onBack = { },
                modifier = modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddMhs,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Mahasiswa",
                )

            }
        }
    )  { innerPadding ->
        val homeUiState by viewModel.homeUiState.collectAsState()

        BodyHomeMhsView(
            homeUiState = homeUiState,
            onClick = {

            },
            modifier = Modifier.padding((innerPadding))
        )
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun BodyHomeMhsView(
    homeUiState: HomeUiState,
    onClick: () -> Unit = { },
    modifier: Modifier = Modifier
) {

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() } //snackbar state
    when {
        homeUiState.isLoading -> {
            //menampilkan indikator loading
            Box (
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        homeUiState.isError -> {
            //menampilkan pesan error
            LaunchedEffect(homeUiState.errorMessage) {
                homeUiState.errorMessage?.let { message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message) //tampilkan snackbar
                    }
                }
            }
        }

        homeUiState.listMhs.isEmpty() -> {
            //menampilkan pesan jika data kosong
            Box (
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Tidak ada data mahasiswa.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        else -> {
            //menampilkan daftar mahasiswa
            ListMahasiswa(
                listMhs = homeUiState.listMhs,
                onClick = { println(it)
                },
                modifier = modifier
            )
        }
    }
}
//fun onClick(it: String) { }

