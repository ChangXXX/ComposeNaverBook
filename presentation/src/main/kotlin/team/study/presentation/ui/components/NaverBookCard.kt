package team.study.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import team.study.domain.model.Book

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NaverBookCard(
    book: Book,
    onClick: () -> Unit,
    onFavorite: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(12.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = book.image,
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "제목 : ${book.title}",
                fontStyle = MaterialTheme.typography.bodySmall.fontStyle,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "저자 : ${book.author}",
                fontStyle = MaterialTheme.typography.bodySmall.fontStyle,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
            )
        }
    }
}

@Preview
@Composable
fun PreviewNaverBookCard() {
    NaverBookCard(
        book = Book(
            title = "컴포즈",
            author = "ChangXXX",
            image = "https://user-images.githubusercontent.com/53431177/229817785-a64af5a9-4ad0-41e9-9733-81aea3e53ad8.png",
        ),
        onClick = { /*TODO*/ },
        onFavorite = { /*TODO*/ },
    )
}
