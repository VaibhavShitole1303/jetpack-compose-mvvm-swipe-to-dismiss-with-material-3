import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(emailViewModel: EmailViewModel ) {
    // Collect the state of messages from the view model
    val messages by emailViewModel.messagesState.collectAsState()

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Home ",
                        style = MaterialTheme.typography.titleMedium
                    ) },
                    actions = {
                        // Refresh button
                        IconButton(onClick = emailViewModel::refresh) {
                            Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 12.dp),
            ) {
                itemsIndexed(
                    items = messages,
                    // Provide a unique key based on the email content
                    key = { _, item -> item.hashCode() }
                ) { _, emailContent ->
                    // Display each email item
                    EmailItem(emailContent, onRemove = emailViewModel::removeItem)
                }
            }
        }
    }
}
