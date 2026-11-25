package com.example.repaso.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repaso.ui.theme.RepasoTheme

@Composable
fun PagosScreen(
    onRealizarPagoClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var miembro by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "registrar pago",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "miembro", style = MaterialTheme.typography.labelLarge)
        OutlinedTextField(
            value = miembro,
            onValueChange = { miembro = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        Text(text = "monto", style = MaterialTheme.typography.labelLarge)
        OutlinedTextField(
            value = monto,
            onValueChange = { monto = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        Button(
            onClick = onRealizarPagoClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "realizar pago")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PagosScreenPreview() {
    RepasoTheme {
        PagosScreen()
    }
}
