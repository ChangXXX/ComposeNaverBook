package team.study.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.style.TextOverflow
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
            .fillMaxWidth(.9f)
            .height(100.dp)
            .padding(top = 12.dp, bottom = 12.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp),
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
            Column(
                modifier = Modifier.padding(start = 12.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f),
            ) {
                Text(
                    text = "제목 : ${book.title}",
                    fontStyle = MaterialTheme.typography.bodySmall.fontStyle,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "저자 : ${book.author}",
                    fontStyle = MaterialTheme.typography.bodySmall.fontStyle,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "출판사 : ${book.publisher}",
                    fontStyle = MaterialTheme.typography.bodySmall.fontStyle,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview
@Composable
fun NaverBookCardPreview() {
    NaverBookCard(
        book = Book(
            title = "컴포즈 책 검색 앱",
            author = "ChangXXX",
            image = "https://shopping-phinf.pstatic.net/main_3527659/35276599620.20221027194759.jpg",
            publisher = "github.com/changXXX",
        ),
        onClick = { /*TODO*/ },
        onFavorite = { /*TODO*/ },
    )
}
